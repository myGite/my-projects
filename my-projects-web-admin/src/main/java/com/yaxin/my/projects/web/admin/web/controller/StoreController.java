package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.Store;
import com.yaxin.my.projects.domain.StoreActivity;
import com.yaxin.my.projects.web.admin.service.StoreActivityService;
import com.yaxin.my.projects.web.admin.service.StoreService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 商家控制层
 */

/**
 * origins:是允许访问的列表（origins=“网址”）
 * maxAge:准备响应前的 缓存持续的 最大时间
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/store")
public class StoreController extends BathController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreActivityService storeActivityService;

    /**
     * 通过商家的id获取商家的活动信息
     */
    @ResponseBody
    @RequestMapping(value = "/storeid")
    public BaseResult storeidFun(HttpServletRequest request, HttpServletResponse response, Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获取从前端传来的商家id
        Integer storeid = Integer.parseInt(request.getParameter("storeid"));
        //通过商家的id获取商家的所有信息
        Store store = storeService.findByStoreId(storeid);
        String activityids1= store.getActivityids();
        /*//定义后台以json格式响应的结果集 map集合
        Map<String,List<StoreActivity>> result=new HashMap<>();*/
        //判断商家是否存在活动
        if (StringUtils.isBlank(activityids1)){//为空时
            /*result.put("storeActivityList",null);
            this.writeJSON(result,0,response);*/
            baseResult=BaseResult.success("该商家目前没有任何活动！");
        }else{
            //获取商家选中了那一些活动的id
            String[] activityids=activityids1.split(",");
            List<StoreActivity> storeActivityList=null;
            //判断商家是否存在活动
            //将获得的活动集放入list表中，用于向StoreActivityMapper.xml文件中传入数据
            List<Integer> activityidList=new ArrayList<>(activityids.length);
            for (String s:activityids){
                activityidList.add(Integer.parseInt(s));
            }
            storeActivityList = storeActivityService.findByStoreActivityId(activityidList);
            /*result.put("storeActivityList",storeActivityList);
            this.writeDataJSON(result,response);*/
            model.addAttribute("storeActivityList",storeActivityList);
            baseResult=BaseResult.success("该商家正在进行的活动如下所示：",model);
        }
        return baseResult;
    }

    /**
     * 通过请求  /store/list  获取所有商家的列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult storeListFun(Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获得所有商家的信息
        List<Store> storesList=storeService.findStoreList();
        //model.addAttribute("storesList",storesList);
        baseResult=BaseResult.success("获取所有商家信息成功！",storesList);
        return baseResult;
    }

    /**
     * 通过请求 /store/pics 获取商家的实景
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pics")
    public BaseResult storePicsFun(HttpServletRequest request,Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获取从前端传来的商家id
        Integer storeid = Integer.parseInt(request.getParameter("storeid"));
        //通过商家的id获取商家的所有信息
        Store store = storeService.findByStoreId(storeid);
        String pics1= store.getPics();
        /*//定义后台以json格式响应的结果集 map集合
        Map<String,List<StoreActivity>> result=new HashMap<>();*/
        //判断商家是否存在实景
        if (StringUtils.isBlank(pics1)){//不存在实景
            /*result.put("storeActivityList",null);
            this.writeJSON(result,0,response);*/
            baseResult=BaseResult.success("该商家很懒，目前没有准备自己商店的背景图片！");
        }else{//存在实景
            //获取商家选中了那一些活动的id
            String[] pics=pics1.split(",");
            List<String> picsList = new ArrayList<>(pics.length);
            Collections.addAll(picsList,pics);
            model.addAttribute("picsList",picsList);
            baseResult=BaseResult.success("该商家的背景图片如下所示：",model);
        }
        return baseResult;
    }

}
