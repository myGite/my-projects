package com.yaxin.my.projects.domain;

import java.io.Serializable;

/**
 * 商品轮播
 */
public class Carousel implements Serializable {

    //商品图片轮播流水id
    private Integer id;
    //商品图片轮播图片名称
    private String picname;
    //商品图片轮播图片样式
    private String picstyle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPicstyle() {
        return picstyle;
    }

    public void setPicstyle(String picstyle) {
        this.picstyle = picstyle;
    }

    @Override
    public String toString() {
        return "carousel{" +
                "id=" + id +
                ", picname='" + picname + '\'' +
                ", picstyle='" + picstyle + '\'' +
                '}';
    }
}
