package com.hairo.springbootmybatisdynamicsql;

import com.google.common.collect.Lists;
import com.hairo.springbootmybatisdynamicsql.entity.SysUser;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserDynamicSqlSupport;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.update.UpdateDSL.update;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisDynamicSqlApplicationTests {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        selectTest();
    }

    public void selectTest(){
        Optional<SysUser> sysUser = sysUserMapper.selectByPrimaryKey(1);
        System.out.println(sysUser);

//        SelectStatementProvider statementProvider = select(SysUserDynamicSqlSupport.userId, SysUserDynamicSqlSupport.userName)
//                .from(SysUserDynamicSqlSupport.sysUser)
//                .where(SysUserDynamicSqlSupport.userId, SqlBuilder.isIn(5,6))
//                .build()
//                .render(RenderingStrategies.MYBATIS3);
//
//        System.out.println("statementProvider->"+sysUserMapper.selectMany(statementProvider));
    }

    public void insertTest(){
        List<SysUser> userList = Lists.newArrayList( );
        for(int i = 7; i < 1000000; i++){
            userList.add(SysUser.builder().address("海罗之家").userAge(15).userName("海罗2号").userId(i).userPassword("123456").build());
        }
        int insertResult = sysUserMapper.insertMultiple(userList);
        System.out.println("批量插入结果->"+insertResult);
        int insertOneResult = sysUserMapper.insert(SysUser.builder().address("海罗之家").userAge(18).userName("海罗6号").userId(6).userPassword("123456").build());
        System.out.println("单条插入结果->"+insertOneResult);
    }

    public void updateTest(){
        SysUser sysUser = SysUser.builder().address("海罗之家").userAge(18).userName("海罗5号").userId(5).userPassword("123456").build();
        //int update = sysUserMapper.update(c -> c.set(SysUserDynamicSqlSupport.address).equalTo("海罗之家-update").where(SysUserDynamicSqlSupport.userId, SqlBuilder.isIn(5, 6)));
//        System.out.println("更新结果->"+update);
        UpdateStatementProvider updateStatement  =  update(SysUserDynamicSqlSupport.sysUser)
                .set(SysUserDynamicSqlSupport.address).equalTo("update-")
                .where(SysUserDynamicSqlSupport.userId,SqlBuilder.isIn(1))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        int update = sysUserMapper.update(updateStatement);
        System.out.println(update);
    }

    public void deleteTest(){

    }
}
