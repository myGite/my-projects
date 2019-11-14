package com.yaxin.my.projects.web.admin.service.impl;

import com.yaxin.my.projects.domain.User;
import com.yaxin.my.projects.web.admin.dao.UserDAO;
import com.yaxin.my.projects.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByNickname(String nickname, String password) {
        User user=userDAO.selectByNickname(nickname);
        if (user != null){
            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public List<User> findUsers(User user) {
        return userDAO.selectByColumns(user);
    }
}
