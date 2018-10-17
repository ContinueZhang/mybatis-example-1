package com.example.mybatisexample1.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author continue
 * @date 2018/10/16
 */
@Data
public class UserEntity {


    private Integer id;
    private String name;
    private String password;
    private String email;
    private String profile;
    private Date time;

}
