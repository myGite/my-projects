package com.yaxin.my.projects.web.admin.dao;

import com.yaxin.my.projects.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    /**
     * 通过登录名查询用户
     * @param nickname
     * @return
     */
    User selectByNickname(String nickname);

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 通过传入的多个字段查询用户
     */
    List<User> selectByColumns(User user);
}
