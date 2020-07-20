package com.hairo.springbootmybatisdynamicsql.update;

import com.hairo.springbootmybatisdynamicsql.entity.SysUser;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserDynamicSqlSupport;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserMapper;
import org.junit.Test;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;

import javax.annotation.Resource;

/**
 * @author Hairo
 * @date 2020/7/15 11:07
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class UpdateTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        String str = null;
        SysUser sysUser = SysUser.builder().build();
        UpdateStatementProvider updateStatementProvider = SqlBuilder.update(SysUserDynamicSqlSupport.sysUser)
                .set(SysUserDynamicSqlSupport.userPassword).equalToWhenPresent(str)
                .set(SysUserDynamicSqlSupport.userName).equalTo(str)
                .where(SysUserDynamicSqlSupport.userId,SqlBuilder.isEqualToWhenPresent(1))
                .build()
                .render(RenderingStrategies.MYBATIS3)
                ;
        System.out.println(updateStatementProvider.getUpdateStatement());
     //   sysUserMapper.update(updateStatementProvider);
    }
}
