package com.example.mybatisexample1;

import com.example.mybatisexample1.domain.entity.RoleEntity;
import com.example.mybatisexample1.mapper.RoleMapper;
import com.example.mybatisexample1.mapper.RoleProviderMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * continue 嘻嘻哈哈
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisExample1ApplicationTests {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleProviderMapper roleProviderMapper;
    private RoleEntity role;

    @Before
    public void getRole() {
        role = new RoleEntity();
        role.setUserId(888888);
        role.setName("insert");
        role.setEffectiveSign(1);
        role.setTime(new Date());
    }

    @Test
    public void insert() {
        role.setId(777777);
        System.out.println(roleMapper.insert(role));
    }

    @Test
    public void insert2() {
        role.setName("insert2");
        roleMapper.insert2(role);
        System.out.println(role.getId());
    }

    @Test
    public void deleteById() {
        System.out.println(roleMapper.deleteById(99999));
    }

    @Test
    public void updateById() {
        RoleEntity update = new RoleEntity();
        update.setId(4);
        update.setName("李四");
        update.setEffectiveSign(3);
        roleMapper.updateById(update);
    }

    @Test
    public void selectById() {
        RoleEntity entity = roleMapper.selectById(4);
        System.out.println(entity.getName());
    }

    @Test
    public void selectByNameAndTime() {
        String name = "四";
        Date time = new Date();
        List<RoleEntity> con = roleMapper.selectByNameAndTime(name, time);
        con.forEach(temp -> System.out.println(temp.getName()));
    }

    @Test
    public void selectAll() {
        List<RoleEntity> con = roleMapper.selectAll();
        con.forEach(temp -> System.out.println(temp.getName()));
    }

    @Test
    public void batchInsert() {
        RoleEntity role2 = new RoleEntity();
        role2.setEffectiveSign(7);
        role2.setName("continue");
        role2.setTime(new Date());
        role2.setUserId(55);
        System.out.println(roleMapper.batchInsert(List.of(role, role2)));
    }

    @Test
    public void dynamicUpdate() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "动态更新的name");
        map.put("effective_sign", 78);
        roleMapper.dynamicUpdate(map, 4);
    }

    @Test
    public void inspireInsert() {
        role.setName("inspireInsert");
        roleMapper.insert2(role);
        roleMapper.inspireInsert(role);
    }

}
