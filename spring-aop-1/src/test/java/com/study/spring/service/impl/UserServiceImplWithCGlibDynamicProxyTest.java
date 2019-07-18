package com.study.spring.service.impl;

import com.study.spring.domain.User;
import com.study.spring.handler.TransationHandlerWithCGlibDynamicProxy;
import com.study.spring.handler.TransationHandlerWithJdkDynamicProxy;
import com.study.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplWithCGlibDynamicProxyTest {
    private UserService userService;
    private User user = null;
    private TransationHandlerWithCGlibDynamicProxy transationHandlerWithCGlibDynamicProxy;
    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(110);
        user.setName("apple");
        //表示是对UserServiceImplWithJdkDynamicProxyTest进行代理
        this.transationHandlerWithCGlibDynamicProxy = new TransationHandlerWithCGlibDynamicProxy(new UserServiceImplWithCGlibDynamicProxy());
        userService = (UserService)this.transationHandlerWithCGlibDynamicProxy.createProxyInstance();
    }

    @Test
    public void addUser() {
        this.userService.addUser(user);
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void modifyUser() {
    }
}