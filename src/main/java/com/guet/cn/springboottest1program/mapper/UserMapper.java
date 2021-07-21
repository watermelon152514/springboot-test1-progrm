package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper //表示这个类是mybatis的mapper类
@Repository //持久层
//@Component
public interface UserMapper {
    List<User> getAllUsers();//获取所有的用户信息。
    User getLastInformation();
    void setUser(User user);
    void addUser(User user);
    void deleteUser(int id);
    List<User> lookforUser(String name);
}
