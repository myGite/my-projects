package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单的DAO层
 */
@Repository
public interface OrderDao {
    /**
     * 通过用户id  查询出用户订单
     * @param userid
     * @return
     */
    List<Order> selectByUserid(Integer userid);

    /**
     * 插入订单
     * @param order
     */
    void insertOrders(Order order);

    /**
     * 获取该用户目前最大的订单号（方便后面的订单号++）
     * @param userid
     * @return
     */
    Integer selectOrderid(Integer userid);
}
