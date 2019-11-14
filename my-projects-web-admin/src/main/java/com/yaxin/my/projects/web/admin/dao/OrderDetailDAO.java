package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 订单详情的DAO层
 */
@Repository
public interface OrderDetailDAO {
    /**
     * 通过用户id  查询出用户订单
     * @param userid
     * @return
     */
    List<Map<String,Object>> selectByUserid(Integer userid);

    /**
     * 批量插入订单数据
     * @param list
     */
    void insertOrderDetail(List<OrderDetail> list);

    /**
     * 通过用户的id  查询出订单的总金额
     * @param userid
     * @return
     */
    Double selectTotal(Integer userid);
}
