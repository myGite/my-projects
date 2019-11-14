package com.yaxin.my.projects.web.admin.service;

import com.yaxin.my.projects.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 登录
     * @param nickname
     * @param password
     * @return
     */
    User findByNickname(String nickname,String password);

    /**
     * 注册用户
     * @param user
     */
    void addUser(User user);

    /**
     * 通过传入用户的多个数据查询用户，返回一个list集合
     * @param user
     * @return
     */
    List<User> findUsers(User user);
}
