package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.mapper.UserMapper;
import com.guet.cn.springboottest1program.bean.User;
import com.guet.cn.springboottest1program.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
//    private RedisTemplate redisTemplate;

    @Transactional  //开启事务
    @Override
    public List<User> getAllUsers() {

//        redisTemplate.opsForValue().append(1,"1");
        return userMapper.getAllUsers();
    }

    @Override
    public void setUser(User user) {

        userMapper.setUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User getLastInformation() {
        return userMapper.getLastInformation();
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public List<User> lookforUser(String name){
        return userMapper.lookforUser(name);
    }
}
