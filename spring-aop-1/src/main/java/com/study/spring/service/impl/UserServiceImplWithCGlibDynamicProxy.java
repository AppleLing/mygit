package com.study.spring.service.impl;


import com.study.spring.domain.User;
import com.study.spring.service.UserService;

public class UserServiceImplWithCGlibDynamicProxy implements UserService {
    @Override
    public void addUser(User user) {
        System.out.println("cglib add User :" + user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("cglib delete User :" + user);
    }

    @Override
    public void modifyUser(User user) {
        System.out.println("cglib modify User :" + user);
    }
}
