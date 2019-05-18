package com.zjf.transaction;

import com.zjf.transaction.model.OrderInfo;

import java.util.List;

public class Provider {
    /* 批量删除 */
    public String batchDeleteShopcart(String userId, List list) {
        return getString(list, "DELETE FROM t_shopcart WHERE user_id = #{userId} and commodity_id IN (");
    }

    /* 批量删除 */
    public String batchDeleteMain(List list) {
        return getString(list, "DELETE FROM t_commodity WHERE id IN (");
    }


    /*
        标记商品已经售出
     */
    public String batchUpdateMain(List<String> list) {
        return getString(list, "update t_commodity set is_sold=true where id in (");
    }

    private String getString(List list, String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < list.size(); i++) {
            sb.append("'").append(list.get(i)).append("'");
            if (i < list.size() - 1)
                sb.append(",");
        }
        sb.append(")");
        return sb.toString();
    }


    /**
     * 批量插入订单详情表
     * @param list
     * @return
     */
    public String batchInsertOrderInfo(List<OrderInfo> list) {
        return getInsertString(list, "insert into t_order_info(order_id,user_id,user_name,user_pic_url,commodity_id,image_url,msg,price) values");
    }

    private String getInsertString(List<OrderInfo> list, String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < list.size(); i++) {
            sb.append("('").append(list.get(i).getOrderId()).append("'").append(",")
                    .append("'").append(list.get(i).getUserId()).append("'").append(",")
                    .append("'").append(list.get(i).getUserName()).append("'").append(",")
                    .append("'").append(list.get(i).getUserPicUrl()).append("'").append(",")
                    .append("'").append(list.get(i).getCommodityId()).append("'").append(",")
                    .append("'").append(list.get(i).getImageUrl()).append("'").append(",")
                    .append("'").append(list.get(i).getMsg()).append("'").append(",")
                    .append("'").append(list.get(i).getPrice()).append("'").append(")");
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
