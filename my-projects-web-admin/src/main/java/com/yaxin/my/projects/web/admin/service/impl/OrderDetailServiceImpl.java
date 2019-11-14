package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.OrderDetail;
import com.yaxin.my.projects.web.admin.dao.OrderDetailDAO;
import com.yaxin.my.projects.web.admin.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单详情Service 的实现类
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    /**
     * 获取用户订单详情的实现类
     * @param userid
     * @return
     */
    @Override
    public List<Map<String, Object>> findByUserid(Integer userid) {
        return orderDetailDAO.selectByUserid(userid);
    }

    /**
     * 批量向订单详情中插入数据
     * @param list
     */
    @Override
    public void addOrderDetail(List<OrderDetail> list) {
        orderDetailDAO.insertOrderDetail(list);
    }

    /**
     * 获取订单详情中用户消费的总金额
     * @param userid
     * @return
     */
    @Override
    public Double findTotal(Integer userid) {
        return orderDetailDAO.selectTotal(userid);
    }
}
