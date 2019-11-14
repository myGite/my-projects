package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * 订单详情的Service接口
 */
public interface OrderDetailService {
    /**
     * 通过传来的用户id  获取用户的订单信息
     * @param userid
     * @return
     */
    List<Map<String,Object>> findByUserid(Integer userid);

    /**
     * 批量插入订单数据
     * @param list
     */
    void addOrderDetail(List<OrderDetail> list);

    /**
     * 通过传来的用户id  获取订单中的总金额
     * @param userid
     * @return
     */
    Double findTotal(Integer userid);
}
