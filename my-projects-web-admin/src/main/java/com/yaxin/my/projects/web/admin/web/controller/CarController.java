package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.Car;
import com.yaxin.my.projects.domain.Goods;
import com.yaxin.my.projects.web.admin.service.CarService;
import com.yaxin.my.projects.web.admin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 加入购物车的控制层
 */
@Controller
@RequestMapping("/car")
public class CarController extends BathController {

    @Autowired
    private CarService carService;

    @Autowired
    private GoodsService goodsService;

    /**
     * 通过 /car/list?userid=_ 请求获取该用户购物车的信息
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public BaseResult carListFun(HttpServletRequest request, HttpServletResponse response, Model model){
        Integer userid = Integer.parseInt(request.getParameter("userid"));
        Car car=new Car();
        car.setUserid(userid);
        List<Map<String, Object>> carList = carService.findCar(car);
        //自定义给前台响应的结果集
        BaseResult baseResult =null;
        //自定义Map集合，用于给前台页面的响应
        //Map<String,Object> result=new HashMap<>();
        if (carList!=null && carList.size()>0){
            /*result.put("code",1);
            result.put("message","");
            result.put("carList",carList);
            this.writeDataJSON(result,response);*/
            model.addAttribute("carList",carList);
            baseResult=BaseResult.success("您的购物车里面的商品列表如下：",model);
        }else{
            /*result.put("code",0);
            result.put("message","您的购物车真干净啊！");
            this.writeDataJSON(result,response);*/
            baseResult=BaseResult.fail(500,"您的购物车页面真干净啊！");
        }
        return baseResult;
    }

    /**
     * 通过 /car/add 请求完成   加入购物车  的功能
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public BaseResult carAddFun(HttpServletRequest request,HttpServletResponse response){
        //引用自定义的后台给前台响应的结构集
        BaseResult baseResult=null;
        //获取用户的id
        Integer userid=Integer.parseInt(request.getParameter("userid"));
        //获取商品的id
        Integer goodsid = Integer.parseInt(request.getParameter("goodsid"));
        //获取是否是点击了“+”，还是“-”
        Integer number = Integer.parseInt(request.getParameter("number"));
        /**
         * 判断添加的商品在购物车中是否存在
         * 不存在，则添加购物车
         * 存在，则修改购物车
         */
        Car car=new Car();
        car.setGoodsid(goodsid);
        car.setUserid(userid);
        List<Map<String,Object>> goodsidList=carService.findCar(car);

        /**
         * 获取商品的信息，目的是得到商品的单价
         */
        Goods goods1=new Goods();
        goods1.setGoodsid(goodsid);
        Goods goods=goodsService.findByColumns(goods1);
        //修改购物车
        if (goodsidList != null && goodsidList.size()>0){
            Car car1=carService.findOne(car);
            //如果是“+”
            if (number == 1){
                car.setGoodsnum(car1.getGoodsnum()+1);
                car.setGoodssum(car1.getGoodssum()+goods.getGoodsprice());
                carService.editCar(car);
                baseResult=BaseResult.success("添加购物车成功！");
            }
            //如果是“-”
            else {
                //在进行“-”时，需要先判断当前商品数是否为1，如果为1，这直接删除这个商品，反正这进行见一个商品的操作
                if (car1.getGoodsnum()==1){
                    carService.deleteOne(car);
                    baseResult=BaseResult.success("清空购物车成功！");
                }else{
                    //如果是“-”
                    car.setGoodsnum(car1.getGoodsnum()-1);
                    car.setGoodssum(car1.getGoodssum()-goods.getGoodsprice());
                    carService.editCar(car);
                    baseResult=BaseResult.success("减少一个商品成功！");
                }
            }
        }
        //添加购物车
        else {
            //car.setUserid(userid);
            car.setGoodsnum(1);
            car.setGoodssum(goods.getGoodsprice());
            carService.addCar(car);
            /*Map<String,Object> result=new HashMap<>();
            result.put("code",1);
            result.put("message","添加购物车成功！");
            this.writeDataJSON(result,response);*/
            baseResult=BaseResult.success("添加购物车成功！");
        }
        return baseResult;
    }
}
