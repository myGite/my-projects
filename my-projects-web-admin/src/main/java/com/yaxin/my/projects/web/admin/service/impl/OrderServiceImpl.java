package com.yaxin.my.projects.web.admin.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yaxin.my.projects.domain.Order;
import com.yaxin.my.projects.domain.OrderDetail;
import com.yaxin.my.projects.web.admin.dao.OrderDao;
import com.yaxin.my.projects.web.admin.dao.OrderDetailDAO;
import com.yaxin.my.projects.web.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单Service 的实现类
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    /**
     * 获取用户订单信息
     * @param userid
     * @return
     */
    @Override
    public List<Order> findByUserid(Integer userid) {
        return orderDao.selectByUserid(userid);
    }

    /**
     * 同时添加订单和订单详情信息（需要运用到Spring 事务管理）
     * @param userid1
     * @param orderDetailJson1
     */
    @Override
    public void addOrder(String userid1, String orderDetailJson1) {
        //利用java代码将获取的json字符串  转换成  list对象
        Gson gson = new Gson();
        List<OrderDetail> orderDetails = gson.fromJson(orderDetailJson1, new TypeToken<ArrayList<OrderDetail>>() {
        }.getType());
        //获取系统的当前时间，因为前台没有传递时间，而订单和订单详情中还需要一个订单时间
        Date date = new Date();
        //获取用户的id
        int userid = Integer.parseInt(userid1);
        //获取当前用户最大的订单号并加一，成为当前的订单号
        Integer orderid1 = orderDao.selectOrderid(userid);
        //声明一个订单号
        int orderid;
        if (orderid1 == null) {
            orderid = 1;
        } else {
            orderid = orderid1.intValue() + 1;
        }
            /*
             * 实现订单信息的添加
             */
        Order order = new Order();
        order.setOrderid(orderid);
        order.setUserid(userid);
        order.setOrderDate(date);
        orderDao.insertOrders(order);
        List<OrderDetail> orderDetailList = new ArrayList<>(orderDetails.size());
            /*
             * 为订单详情中添加订单时间，订单id，各类商品对应的总销售额（并不是整个订单的总销售额）
             */
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderDate(date);
            orderDetail.setOrderid(orderid);
            orderDetail.setGoodssum(orderDetail.getGoodsnum() * orderDetail.getGoodsprice());
            orderDetailList.add(orderDetail);
        }
        orderDetailDAO.insertOrderDetail(orderDetailList);
    }

    /**
     * 获取用户目前最大的订单号
     * @param userid
     * @return
     */
    @Override
    public Integer findOrderid(Integer userid) {
        return orderDao.selectOrderid(userid);
    }
}
