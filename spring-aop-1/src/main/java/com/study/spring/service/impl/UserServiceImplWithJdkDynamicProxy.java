package com.study.spring.service.impl;


import com.study.spring.domain.User;
import com.study.spring.service.UserService;

public class UserServiceImplWithJdkDynamicProxy implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("add User :" + user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("delete User :" + user);
    }

    @Override
    public void modifyUser(User user) {
        System.out.println("modify User :" + user);
    }
}
