package com.example.mybatisexample1.mapper;

import com.example.mybatisexample1.domain.entity.RoleEntity;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by continue on 2018/10/16.
 */

public interface RoleMapper {


    /**
     * 不返回主键的新增
     *
     * @param role 角色实体
     * @return 影响数据库的行数 1
     */
    @Insert("INSERT INTO t_role(id,user_id,name,effective_sign,time) VALUES(#{id},#{userId},#{name},#{effectiveSign},#{time,jdbcType=TIMESTAMP})")
    int insert(RoleEntity role);

    /**
     * < selectKey keyColumn =” id ” resultType =” long ” keyProperty =” id ” order =” AFTER ”>
     * SELECT LAST INSERT ID {)
     * < /selectKey>
     *
     * @param role 角色实体
     * @return 增加的主键
     */
    @Insert("INSERT INTO t_role(user_id,name,effective_sign,time) VALUES(#{userId},#{name},#{effectiveSign},#{time,jdbcType=TIMESTAMP})")
    @SelectKey(
            statement = "SELECT nextval('seq_role')",
            keyProperty = "id",
            resultType = Integer.class,
            before = false
    )
    int insert2(RoleEntity role);

    @Delete("DELETE FROM t_role WHERE id = #{id}")
    int deleteById(Integer id);

    @Update("UPDATE t_role SET name = #{name},effective_sign = #{effectiveSign} WHERE id = #{id}")
    int updateById(RoleEntity role);


    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "effectiveSign", column = "effectiveSign"),
            @Result(property = "time", column = "time")
    })

    @Select("SELECT id,user_id,name,effective_sign,time FROM t_role where id = #{id}")
    RoleEntity selectById(Integer id);

    @ResultMap("roleResultMap")
    @Select("SELECT id,userId,name,effectiveSign,time FROM t_role where upper(name) like concat('%',upper(#{name}),'%') AND time < #{time} ")
    List<RoleEntity> selectByNameAndTime(String name, Date time);

    @Select("SELECT id,user_id,name,effective_sign,time FROM t_role")
    @ResultMap("roleResultMap")
    List<RoleEntity> selectAll();


    @Insert("<script>" +
            "INSERT INTO t_role (user_id,name,effective_sign,time) VALUES" +
            "<foreach collection='roleList' item='role' separator=','>" +
            "(" +
            "#{role.userId},#{role.name},#{role.effectiveSign},#{role.time,jdbcType=TIMESTAMP}" +
            ")" +
            "</foreach>" +
            "</script>")
    int batchInsert(@Param("roleList") List<RoleEntity> roleList);


    @Update("<script>" +
            "UPDATE t_role SET " +
            "<foreach collection='map' item='val' index='key' separator=','>" +
            "${key} = #{val}" +
            "</foreach>" +
            "WHERE id = #{id}" +
            "</script>")
    void dynamicUpdate(@Param("map") Map<String, Object> map, @Param("id") Integer id);

//    @ResultMap("roleResultMap")
//    @Select("<script>" +
//            "SELECT id,userId,name,effectiveSign,time FROM t_role where " +
//            "<bind name='nameLike' value='\"%\"+name+\"%\"'/>" +
//            "upper(name) like upper(#{name}) " +
//            "AND time < #{time} " +
//            "</script>")
//    List<RoleEntity> selectByNameAndTimeBind(String name, Date time);


    /**
     * 启发用法
     */
    @Insert("<script>" +
            "INSERT INTO t_role(id,user_id,name,effective_sign,time) VALUES(" +
            "#{id},#{userId}," +
            "<bind name='overwriteName' value='@com.example.mybatisexample1.domain.entity.RoleEntity@overwriteName(name)'/>" +
            "#{overwriteName},#{effectiveSign},#{time,jdbcType=TIMESTAMP}" +
            ")" +
            "</script>")
    @Options(useGeneratedKeys = true)
    int inspireInsert(RoleEntity role);

}
