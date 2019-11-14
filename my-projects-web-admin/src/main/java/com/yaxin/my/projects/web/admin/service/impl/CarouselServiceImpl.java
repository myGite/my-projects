package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.Carousel;
import com.yaxin.my.projects.web.admin.dao.CarouselDAO;
import com.yaxin.my.projects.web.admin.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片轮播的Service的实现类
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDAO carouselDAO;

    /**
     * 获取所有的轮播图
     * @return
     */
    @Override
    public List<Carousel> findAll() {
        return carouselDAO.selectCarousel();
    }
}
