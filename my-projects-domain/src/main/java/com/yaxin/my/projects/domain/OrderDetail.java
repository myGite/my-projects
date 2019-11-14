package com.yaxin.my.projects.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 */
public class OrderDetail implements Serializable {
    //流水id
    private Integer id;
    //订单id
    private Integer orderid;
    //商品id
    private Integer goodsid;
    //商品数量
    private Double goodsnum;
    //用户id
    private Integer userid;
    //商品单价
    private Double goodsprice;
    //每一种商品对应的总金额
    private Double goodssum;
    //订单时间
    private Date orderDate;
    //配送方式id
    private Integer deliverid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Double getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Double goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Double getGoodssum() {
        return goodssum;
    }

    public void setGoodssum(Double goodssum) {
        this.goodssum = goodssum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(Integer deliverid) {
        this.deliverid = deliverid;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", goodsid=" + goodsid +
                ", goodsnum=" + goodsnum +
                ", userid=" + userid +
                ", goodsprice=" + goodsprice +
                ", goodssum=" + goodssum +
                ", orderDate=" + orderDate +
                ", deliverid=" + deliverid +
                '}';
    }
}
