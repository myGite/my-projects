package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.Carousel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图片轮播的DAO层
 */
@Repository
public interface CarouselDAO {
    //查询出所有轮播表里面的图片
    public List<Carousel> selectCarousel();
}
