package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.Carousel;

import java.util.List;

/**
 * 图片轮播的Service层
 */
public interface CarouselService {
    //获取所有的轮播图的名称和图片
    List<Carousel> findAll();
}
