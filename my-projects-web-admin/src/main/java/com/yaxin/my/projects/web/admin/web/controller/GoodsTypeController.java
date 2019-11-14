package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.GoodsType;
import com.yaxin.my.projects.web.admin.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品类型控制层
 */
@Controller
@RequestMapping(value = "/api/shop")
public class GoodsTypeController extends BathController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 商品所有类型的显示
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/type")
    public BaseResult goodsTypeFun(HttpServletRequest request, HttpServletResponse response, Model model){
        /*//定义一个Map集合，主要用于存放需要给前台响应的所有数据
        Map<String,List<GoodsType>> result=new HashMap<>();*/
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获取所有的商品类型    用于左边菜单的显示
        List<GoodsType> goodsTypeList=goodsTypeService.findAll();
        //将获得的所有商品类型放入Map集合中，用于传入前台
        /*result.put("goodsTypeList",goodsTypeList);
        //用自定义的json数据格式给前台反馈数据
        this.writeDataJSON(result,response);*/
        model.addAttribute("goodsTypeList",goodsTypeList);
        baseResult = BaseResult.success("所有商品类型的信息如下所示：",model);
        return baseResult;
    }
}
