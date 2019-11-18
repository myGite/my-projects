package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.Carousel;
import com.yaxin.my.projects.web.admin.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 轮播图的控制器
 */
@Controller
@RequestMapping(value = "/api")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     * 获取所有的轮播图
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/index_category")
    public BaseResult indexCategory(Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获取所有的轮播图片
        List<Carousel> carouselList = carouselService.findAll();
        model.addAttribute("carouselList",carouselList);
        baseResult=BaseResult.success("获取所有商家信息成功！",model);
        return baseResult;
    }
}
