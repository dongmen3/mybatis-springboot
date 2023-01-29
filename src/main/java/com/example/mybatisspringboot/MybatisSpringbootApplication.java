package com.example.mybatisspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisSpringbootApplication {
    public static UserMapper userMapper;
    public MybatisSpringbootApplication(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    public static void main(String[] args) {

        SpringApplication.run(MybatisSpringbootApplication.class, args);
        //userMapper.findUsers().forEach(user -> System.out.println(user.getName()));
    }

}
