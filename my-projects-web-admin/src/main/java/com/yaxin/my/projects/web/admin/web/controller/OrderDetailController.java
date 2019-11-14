package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.web.admin.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 订单详情的控制器
 */
@Controller
@RequestMapping(value = "/orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 通过请求  /orderdetail/list  获取该用户最近一次的消费订单详情
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult orderdetailListFun(HttpServletRequest request, Model model){
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult=null;
        //获取前台传递过来的用户id
        Integer userid=Integer.parseInt(request.getParameter("userid"));
        //获取用户的当前订单
        List<Map<String,Object>> orderDetailList=orderDetailService.findByUserid(userid);
        //获取用户订单详情上面消费的总金额
        Double orderDetailTotal=orderDetailService.findTotal(userid);
        model.addAttribute("orderDetailList",orderDetailList);
        model.addAttribute("orderDetailTotal",orderDetailTotal);
        baseResult = BaseResult.success("您的订单信息如下所示：",model);
        return baseResult;
    }

}
