package com.example.mybatisexample1.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author continue
 * @date 2018/10/16
 */
@Data
public class RoleEntity {


    private Integer id;
    private Integer userId;
    private String name;
    private Integer effectiveSign;
    private Date time;

    public static String overwriteName(String name) {
        return name + "，哈哈哈";
    }

}
