package com.study.spring.service.impl;

import com.study.spring.domain.User;
import com.study.spring.handler.TransationHandlerWithJdkDynamicProxy;
import com.study.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;


public class UserServiceImplWithJdkDynamicProxyTest {

    private UserService userService;
    private User user = null;
    private TransationHandlerWithJdkDynamicProxy transationHandlerWithJdkDynamicProxy;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(110);
        user.setName("apple");
        //表示是对UserServiceImplWithJdkDynamicProxyTest进行代理
        this.transationHandlerWithJdkDynamicProxy = new TransationHandlerWithJdkDynamicProxy(new UserServiceImplWithJdkDynamicProxy());
        userService = (UserService)this.transationHandlerWithJdkDynamicProxy.createProxyInstance();

    }

    @Test
    public void addUser() {
        this.userService.addUser(user);
    }

    @Test
    public void deleteUser() {
        this.userService.deleteUser(user);
    }

    @Test
    public void modifyUser() {
        this.userService.modifyUser(user);
    }
}