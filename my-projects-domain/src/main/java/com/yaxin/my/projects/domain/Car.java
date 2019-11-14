package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 购物车
 */
public class Car implements Serializable {
    //购物车id
    private Integer id;
    //用户id
    private Integer userid;
    //商品id
    private Integer goodsid;
    //商品id对应的数量
    private Integer goodsnum;
    //商品id对应的总价
    private Double goodssum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Double getGoodssum() {
        return goodssum;
    }

    public void setGoodssum(Double goodssum) {
        this.goodssum = goodssum;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodsid=" + goodsid +
                ", goodsnum=" + goodsnum +
                ", goodssum=" + goodssum +
                '}';
    }
}
