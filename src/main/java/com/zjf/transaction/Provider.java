package com.zjf.transaction;

import java.util.List;

public class Provider {
    /* 批量删除 */
    public java.lang.String batchDeleteShopcart(String userId, List list) {
        return getString(list, "DELETE FROM t_shopcart WHERE user_id = #{userId} and commodity_id IN (");
    }

    /* 批量删除 */
    public java.lang.String batchDeleteMain(List list) {
        return getString(list, "DELETE FROM t_commodity WHERE id IN (");
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
}
