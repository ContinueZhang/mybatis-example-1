package com.example.mybatisexample1.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author continue
 * @date 2018/10/16
 */
@Data
public class AuthorityEntity {


    private Integer id;
    private String name;
    private String url;
    private Date time;

}
