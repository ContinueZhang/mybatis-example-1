package com.example.mybatisexample1.mapper;

import com.example.mybatisexample1.domain.entity.RoleEntity;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by continue on 2018/10/16.
 */
public interface RoleProviderMapper {

    @SelectProvider(type = RoleProviderFactory.class, method = "selectById")
    RoleEntity selectById(Integer id);

    @InsertProvider(type = RoleProviderFactory.class, method = "batchInsert")
    int batchInsert(List<RoleEntity> roleList);

    class RoleProviderFactory {
        public String selectById(final Integer id) {
            return new SQL() {
                {
                    SELECT("id,userId,name,effectiveSign,time");
                    FROM("t_role");
                    WHERE("id = #{id}");
                }
            }.toString();

            //也可以写语句...
        }

        public String batchInsert(final List<RoleEntity> roleList) {
            return new SQL() {
                {
                    INSERT_INTO("t_role");
                    for (RoleEntity role : roleList) {
                        VALUES("userId", "#{userId}");
                        VALUES("name", "#{name}");
                        VALUES("effectiveSign", "#{effectiveSign}");
                        VALUES("time", "#{time,jdbcType=TIMESTAMP}");
                    }
                }
            }.toString();

            //也可以写语句...
        }
    }
}
