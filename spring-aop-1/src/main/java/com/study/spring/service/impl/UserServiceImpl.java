package com.study.spring.service.impl;

import com.study.spring.domain.User;
import com.study.spring.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser(User user) {
        beginTransaction();
        System.out.println("Add User(): " + user);
        endTransaction();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void modifyUser(User user) {

    }

    private void endTransaction() {
        System.out.println("关闭事务：endTransaction");
    }

    private void beginTransaction() {
        System.out.println("开始启务：beginTransaction");
    }
}
