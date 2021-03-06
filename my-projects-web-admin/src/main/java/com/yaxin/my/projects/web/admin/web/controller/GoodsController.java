package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.Goods;
import com.yaxin.my.projects.domain.GoodsType;
import com.yaxin.my.projects.web.admin.service.GoodsService;
import com.yaxin.my.projects.web.admin.service.GoodsTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品控制层
 */
@Controller
@RequestMapping(value = "/api/shop")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 关于一定类型的商品显示
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/good",method = RequestMethod.GET)
    public BaseResult goodsFun(HttpServletRequest request, HttpServletResponse response, Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        String goodstypeids=request.getParameter("goodstypeids");
        //List<Goods> goodsList=goodsService.findByTypeId(goodstypeids);
        /**
         * 将前台获得的数据放入 map 中，将map中的数据出入对应的mapper.xml文件中（主要用于同时出入多个参数，批量修改）
         */
        Map<String,Object> goodsMap=new HashMap<>();
        if (StringUtils.isBlank(goodstypeids)){
            goodstypeids="";
        }
        goodsMap.put("goodstypeids",goodstypeids);
        List<Goods> goodsList=goodsService.findByTypeId(goodsMap);
        /*//定义一个Map集合    用于存放需要向前端响应的数据
        Map<String,List<Goods>> result=new HashMap<>();*/
        /*//将得到的商品列表放入Map集合中
        result.put("goodsList",goodsList);
        //以自定义的json格式给前台传数据
        this.writeDataJSON(result,response);*/
        model.addAttribute("goodsList",goodsList);
        baseResult = BaseResult.success("关于该类型的商品如下所示：",model);
        return baseResult;
    }

    /**
     * 通过请求 /shop/list  获取所有的商品信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult goodsListFun(Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获得所有的商品
        List<Goods> goodsList = goodsService.findAll();
        model.addAttribute("goodsList",goodsList);
        baseResult=BaseResult.success("所有的商品信息如下所示：",model);
        return baseResult;
    }


    /**
     * 通过出入的商家id，从而响应商品所有的类型和每一种类型中有哪一些商品
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/all")
    public Map<String, List<Object>> goodsAllFun(HttpServletRequest request, Model model){
        //引入自定义的后台向前台响应的结果集
        //BaseResult baseResult=null;
        //前台需要传入商家的id
        String storeid1 = request.getParameter("storeid");
        int storeid = Integer.parseInt(storeid1);
        //获取所有的商品类型id
        List<GoodsType> goodsTypeList = goodsTypeService.findAll();
        Map<String,List<Object>> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        List<Object> list = new ArrayList<>();
        int goodsTypeid;
        for (GoodsType goodsType : goodsTypeList){
            goodsTypeid=goodsType.getGoodstypeid();
            GoodsType goodsType1 = goodsTypeService.findByGoodsTypeId(goodsTypeid);
            map1.put("name",goodsType1.getGoodstypename());
            List<Goods> goodsList = goodsService.findByTowid(storeid, goodsTypeid);
            map1.put("foods",goodsList);
            map1 = new HashMap<>();
            //map.put("foods"+goodsTypeid,map1);
            list.add(map1);
        }
        //获取所有的商品类型
        /*List<GoodsType> goodsTypes = goodsTypeService.findAll();
        model.addAttribute("foods",map);
        //model.addAttribute("goodsTypes",goodsTypes);
        baseResult = BaseResult.success("获取数据成功！",model);
        return baseResult;*/
        map.put("goods", list);
        return map;
    }
}
