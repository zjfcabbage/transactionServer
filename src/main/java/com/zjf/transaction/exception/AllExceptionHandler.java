package com.zjf.transaction.exception;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AllExceptionHandler {
    static Logger logger = LoggerFactory.getLogger(AllExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Data defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        logger.error("", e);
        return ResponseUtil.error(0, e.getMessage());
    }
}
