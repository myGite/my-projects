package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.Order;
import com.yaxin.my.projects.web.admin.service.OrderDetailService;
import com.yaxin.my.projects.web.admin.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 订单的控制层
 */
@Controller
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 通过请求  /order/list  请求获取用户的订单
     *
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult orderListFun(HttpServletRequest request, Model model) {
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult = null;
        //获取前台传递过来的用户id
        Integer userid = Integer.parseInt(request.getParameter("userid"));
        //获取用户的所有订单
        List<Order> orderList = orderService.findByUserid(userid);
        if (orderList != null && orderList.size() > 0) {
            model.addAttribute("orderList", orderList);
            baseResult = BaseResult.success("您的订单信息如下所示：", model);
        } else {
            baseResult = BaseResult.fail("您目前没有任何订单！");
        }
        return baseResult;
    }

    /**
     * 利用Gson的jar包，通过请求  /order/add  完成批量的插入操作（批量添加订单信息和订单详情信息）
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public BaseResult orderAddFun(HttpServletRequest request) {
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult = null;
        //获取用户id
        String userid1 = request.getParameter("userid");
        //获取前台传递到后台的json字符串，注意：获取的orderDetailJson字符串一定要是：[{},{},....]这种格式的，“[]”不可省略
        String orderDetailJson1 = request.getParameter("orderDetailjson");//获取提交上来的订单详情信息
        if (StringUtils.isBlank(orderDetailJson1)) {//为空时
            baseResult = BaseResult.fail("您目前还没有选择任何商品！，请先选择您要购买的商品：");
        } else {
            orderService.addOrder(userid1,orderDetailJson1);
            baseResult = BaseResult.success("添加订单成功！");
        }
        return baseResult;
    }

}
