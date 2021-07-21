package com.guet.cn.springboottest1program.service;


import com.guet.cn.springboottest1program.bean.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User getLastInformation();
    void setUser(User user);
    void addUser(User user);
    void deleteUser(int id);
    List<User> lookforUser(String name);
}
