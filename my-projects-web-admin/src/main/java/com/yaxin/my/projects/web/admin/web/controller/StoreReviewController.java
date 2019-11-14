package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.StoreReview;
import com.yaxin.my.projects.web.admin.service.StoreReviewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商家评论的控制层
 */
@Controller
@RequestMapping(value = "/api/storereview")
public class StoreReviewController extends BathController {

    @Autowired
    private StoreReviewService storeReviewService;

    /**
     * 根据商家的id，获取所有的评论
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult reviewList(HttpServletRequest request, HttpServletResponse response, Model model){
        /*//定义一个Map集合，主要用于存放需要给前台响应的所有数据
        Map<String,Object> result=new HashMap<>();*/
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        String storeid1 = request.getParameter("storeid");
        if (StringUtils.isNotBlank(storeid1)) {
            int storeid = Integer.parseInt(storeid1);
            List<Map<String,Object>> storeReviewList = storeReviewService.findStoreReview(storeid);
            /*result.put("code",1);
            result.put("message","");
            result.put("storeReviewList",storeReviewList);
            this.writeDataJSON(result,response);*/
            if (storeReviewList != null && storeReviewList.size() > 0){
                model.addAttribute("storeReviewList",storeReviewList);
                baseResult=BaseResult.success("该商家的所有评论如下所示：",model);
            }else {
                baseResult=BaseResult.success("该商家目前没有任何评论！");
            }
        }else{
            /*result.put("message","获取该商家的所有评论失败，请检查网络是否连接：");
            result.put("code",0);
            this.writeDataJSON(result,response);*/
            baseResult=BaseResult.fail("获取该商家的所有评论失败，请检查网络是否连接：");
        }
        return baseResult;
    }

    /**
     * 添加商家的评论
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult addReview(HttpServletRequest request, HttpServletResponse response){
        /*//定义一个Map集合，主要用于存放需要给前台响应的所有数据
        Map<String,Object> result=new HashMap<>();*/
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        String storeid1 = request.getParameter("storeid");
        String userid1 = request.getParameter("userid");
        String text = request.getParameter("text");
        String rateType = request.getParameter("rateType");
        String score1 = request.getParameter("score");
        String recommend = request.getParameter("recommend");
        StoreReview storeReview=new StoreReview();
        //商家id
        int storeid = Integer.parseInt(storeid1);
        storeReview.setStoreid(storeid);
        //用户id
        int userid = Integer.parseInt(userid1);
        storeReview.setUserid(userid);
        //用户评价满意
        if ("满意".equals(rateType)){
            storeReview.setRateType(0);
        }
        //用户评价不满意
        else{
            storeReview.setRateType(1);
        }
        //用户评论内容
        storeReview.setText(text);
        //用户评论的时间
        storeReview.setRateTime(new Date());
        //用户给商家的评分
        double score = Double.parseDouble(score1);
        storeReview.setScore(score);
        //用户的推荐
        if (StringUtils.isBlank(recommend)){
            recommend="";
        }
        storeReview.setRecommend(recommend);
        storeReviewService.addStoreReview(storeReview);
        /*result.put("code",1);
        result.put("message","添加评价成功！");
        this.writeDataJSON(result,response);*/
        baseResult=BaseResult.success("添加评价成功！");
        return baseResult;
    }

}
