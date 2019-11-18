package com.yaxin.my.projects.web.admin.web.controller;

import com.yaxin.my.projects.commons.dto.BaseResult;
import com.yaxin.my.projects.domain.User;
import com.yaxin.my.projects.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户控制层
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户的登录
     *
     * @param request
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public BaseResult login(HttpServletRequest request, HttpServletResponse response, Model model) {
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult = null;
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        User user = userService.findByNickname(nickname, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            model.addAttribute("user", user);
            baseResult = BaseResult.success("登录成功！", model);
        } else {
            baseResult = BaseResult.fail("登录失败，用户名或者密码错误！");
        }
        return baseResult;
    }

    /**
     * 用户的注册
     */
    @ResponseBody
    @RequestMapping(value = "/registers")
    public BaseResult register(@RequestParam MultipartFile avatar, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // File uploadedFile = new File(request.getSession().getServletContext().getRealPath("/")+"/assets/avatar/" + avatar.getOriginalFilename());
        //获取上传文件名    avatar.getOriginalFilename()获取图片的图片名，包含了图片的后缀名
        String fileName = avatar.getOriginalFilename();
        //获取后缀名
        String sname = fileName.substring(fileName.lastIndexOf("."));
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取当前时间并作为时间戳
        String timeStamp = simpleDateFormat.format(new Date());
        //拼接新的文件名
        String newAvatar = "头像" + timeStamp + sname;
        //将图片部署到服务器上面
        File uploadedFile = new File(request.getSession().getServletContext().getRealPath("/") + "/static/assets/avatar/" + newAvatar);
        //System.out.println(request.getSession().getServletContext().getRealPath("/")+"/assets/avatar/" + avatar.getOriginalFilename());
        // 上传保存       transferTo(File uploadeFile): 主要就是用来把 MultipartFile   转换成  File   将文件存储到uploadeFile路径下
        avatar.transferTo(uploadedFile);
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String avatar1 = avatar.getOriginalFilename();
        //引入自定义的后台向前台响应的结果集
        BaseResult baseResult = null;
        User user = new User();
        user.setNickname(nickname);
        List<User> userList = userService.findUsers(user);
        if (userList != null && userList.size() > 0) {
            //this.writeJSON("该登录名已存在！注册失败，请返回到登录页面：", 0, response);
            baseResult = BaseResult.fail("该登录名已存在！注册失败，请返回到登录页面：");
        } else {
            user.setNickname(nickname);
            user.setPassword(password);
            user.setTel(tel);
            user.setAddress(address);
            user.setAvatar(avatar1);
            userService.addUser(user);
            /*//this.writeJSON("注册成功！", 1, response);
            baseResult = BaseResult.success("注册成功！");*/
            baseResult = BaseResult.success("注册用户成功");
        }
        return baseResult;
    }

}
