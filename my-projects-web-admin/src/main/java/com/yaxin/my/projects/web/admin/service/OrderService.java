package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.Order;

import java.util.List;

/**
 * 订单的Service接口
 */
public interface OrderService {
    /**
     * 通过传来的用户id  获取用户的订单信息
     * @param userid
     * @return
     */
    List<Order> findByUserid(Integer userid);

    /**
     * 同时添加订单和订单详情信息（需要运用到Spring 事务管理）
     * @param userid1
     * @param orderDetailJson1
     */
    void addOrder(String userid1, String orderDetailJson1);

    /**
     * 通过传来的用户id 获取用户目前订单上面最大的订单号
     * @param userid
     * @return
     */
    Integer findOrderid(Integer userid);
}
