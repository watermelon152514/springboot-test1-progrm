package com.guet.cn.springboottest1program;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.guet.cn.springboottest1program.mapper")
@EnableTransactionManagement  //开启事务
public class SpringbootTest1ProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest1ProgramApplication.class, args);
    }

}
