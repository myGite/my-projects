package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 商品
 */
public class Goods implements Serializable {
    //商品id
    private Integer goodsid;
    //商品名称
    private String goodsname;
    //商品单价
    private Double goodsprice;
    //月销售量
    private Integer monthsale;
    //商品百分比
    private Double goodpercent;
    //商品图标
    private String goodsimg;
    //商品所属类型id集
    private String goodstypeids;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getMonthsale() {
        return monthsale;
    }

    public void setMonthsale(Integer monthsale) {
        this.monthsale = monthsale;
    }

    public Double getGoodpercent() {
        return goodpercent;
    }

    public void setGoodpercent(Double goodpercent) {
        this.goodpercent = goodpercent;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public String getGoodstypeids() {
        return goodstypeids;
    }

    public void setGoodstypeids(String goodstypeids) {
        this.goodstypeids = goodstypeids;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", monthsale=" + monthsale +
                ", goodpercent=" + goodpercent +
                ", goodsimg='" + goodsimg + '\'' +
                ", goodstypeids='" + goodstypeids + '\'' +
                '}';
    }
}
