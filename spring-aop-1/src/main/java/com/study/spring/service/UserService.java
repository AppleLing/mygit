package com.study.spring.service;

import com.study.spring.domain.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(User user);
    void modifyUser(User user);
}
