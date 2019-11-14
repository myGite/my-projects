package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 商家
 */
public class Store implements Serializable {
    //商家id
    private Integer storeid;
    //商家名称
    private String storename;
    //商家地址
    private String storeadd;
    //商家描述
    private String storedesc;
    //商家评分
    private Double rate;
    //配送方式id
    private Integer deliverid;
    //商家实景
    private String pics;
    //营业时间
    private String storetime;
    //商家电话
    private String storephone;
    //起送价
    private Double beginprice;
    //商家活动id
    private String activityids;
    //月销售量
    private Integer monthsale;
    //配送费
    private Double startprice;

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getStoreadd() {
        return storeadd;
    }

    public void setStoreadd(String storeadd) {
        this.storeadd = storeadd;
    }

    public String getStoredesc() {
        return storedesc;
    }

    public void setStoredesc(String storedesc) {
        this.storedesc = storedesc;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(Integer deliverid) {
        this.deliverid = deliverid;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getStoretime() {
        return storetime;
    }

    public void setStoretime(String storetime) {
        this.storetime = storetime;
    }

    public String getStorephone() {
        return storephone;
    }

    public void setStorephone(String storephone) {
        this.storephone = storephone;
    }

    public Double getBeginprice() {
        return beginprice;
    }

    public void setBeginprice(Double beginprice) {
        this.beginprice = beginprice;
    }

    public String getActivityids() {
        return activityids;
    }

    public void setActivityid(String activityid) {
        this.activityids = activityids;
    }

    public Integer getMonthsale() {
        return monthsale;
    }

    public void setMonthsale(Integer monthsale) {
        this.monthsale = monthsale;
    }

    public Double getStartprice() {
        return startprice;
    }

    public void setStartprice(Double startprice) {
        this.startprice = startprice;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeid=" + storeid +
                ", storename='" + storename + '\'' +
                ", storeadd='" + storeadd + '\'' +
                ", storedesc='" + storedesc + '\'' +
                ", rate=" + rate +
                ", deliverid=" + deliverid +
                ", pics='" + pics + '\'' +
                ", storetime='" + storetime + '\'' +
                ", storephone='" + storephone + '\'' +
                ", beginprice=" + beginprice +
                ", activityid=" + activityids +
                ", monthsale=" + monthsale +
                ", startprice=" + startprice +
                '}';
    }
}
