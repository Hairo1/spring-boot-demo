package com.hairo.springbootmybatisgenerator;

import com.hairo.springbootmybatisgenerator.mappers.SysUserDynamicSqlSupport;
import com.hairo.springbootmybatisgenerator.mappers.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisGeneratorApplicationTests {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
   public void contextLoads() {

        long i = sysUserMapper.count(selectModelCountDSL -> selectModelCountDSL.where(SysUserDynamicSqlSupport.userName, SqlBuilder.isEqualTo("萌萌")));
        System.out.println(i);
    }

}
