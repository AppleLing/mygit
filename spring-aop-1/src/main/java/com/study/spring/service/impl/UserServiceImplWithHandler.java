package com.study.spring.service.impl;

import com.study.spring.domain.User;
import com.study.spring.handler.TransactionHandler;
import com.study.spring.service.UserService;

public class UserServiceImplWithHandler extends TransactionHandler implements UserService {
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
}
