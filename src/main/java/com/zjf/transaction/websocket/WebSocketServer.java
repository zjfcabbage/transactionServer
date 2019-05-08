package com.zjf.transaction.websocket;


import com.google.gson.Gson;
import com.zjf.transaction.model.Msg;
import com.zjf.transaction.service.MsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/webSocket/{userId}")
public class WebSocketServer {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //记录在线连接数
    private static int onlineCount = 0;
    //concurrent包的线程安全set，用来存放每个客户端对应的websocket对象
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    //与客户端的session，通过session给客户端发送消息
    private Session session;
    //接受userId
    private String userId = "";

    private static ApplicationContext applicationContext;
    private static MsgService msgService;

    //此处是解决无法注入的关键
    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
        WebSocketServer.msgService = applicationContext.getBean(MsgService.class);
    }


    /**
     * 连接建立成功调用的方法，在连接成功之后，查询数据库是否有未发送给此用户的消息，有则发送，完成后清除消息，无则忽略
     *
     * @param session
     * @param userId  用户的id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        log.debug("连接建立：" + userId);
        webSocketMap.put(userId, this);
        this.session = session;
        this.userId = userId;
        addOnlineCount(); //连接数+1
        List<Msg> msgList = msgService.getMsgByUserId(userId);  //获取用户暂存的消息
        if (!msgList.isEmpty()) {
            sendObject(msgList);
            msgService.deleteMsgByUserId(userId);
        }
    }

    @OnClose
    public void onClose(@PathParam("userId") String userId) {
        webSocketMap.remove(userId);
        subOnlineCount();
        log.debug("连接断开：" + userId);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.debug("收到消息：" + message);
        Msg msg = new Gson().fromJson(message, Msg.class);
        String toUserId = msg.getToId();
        WebSocketServer webSocketServer = webSocketMap.get(toUserId);
        if (webSocketServer != null) {
            //用户在线
            webSocketServer.sendMessage(message);
        } else {
            //用户不在线，将消息保存到数据库
            msgService.addToUserById(msg);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("连接出错", throwable);
        throwable.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) {
        String msg = new Gson().toJson(object);
        this.sendMessage(msg);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
