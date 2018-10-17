package com.example.mybatisexample1.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author continue
 * @date 2018/10/16
 */
@Data
public class RoleAuthorityEntity {


    private Integer id;
    private Integer roleId;
    private Integer authorityId;
    private Date time;

}
