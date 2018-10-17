package com.example.mybatisexample1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisexample1.mapper")
public class MybatisExample1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisExample1Application.class, args);
    }
}
