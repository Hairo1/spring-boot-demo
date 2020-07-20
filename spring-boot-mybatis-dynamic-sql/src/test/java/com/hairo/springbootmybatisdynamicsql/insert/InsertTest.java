package com.hairo.springbootmybatisdynamicsql.insert;

import com.hairo.springbootmybatisdynamicsql.mappers.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Hairo
 * @date 2020/7/15 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {

    }
}
