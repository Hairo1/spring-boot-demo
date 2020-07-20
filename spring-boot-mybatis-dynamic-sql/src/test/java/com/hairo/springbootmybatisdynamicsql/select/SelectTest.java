package com.hairo.springbootmybatisdynamicsql.select;

import com.google.common.collect.Lists;
import com.hairo.springbootmybatisdynamicsql.entity.SysUser;
import com.hairo.springbootmybatisdynamicsql.mappers.OrderDynamicSqlSupport;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserDynamicSqlSupport;
import com.hairo.springbootmybatisdynamicsql.mappers.SysUserMapper;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author Hairo
 * @date 2020/7/15 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {

    }
    @Test
    public void dslSelectTest(){
        //全查询
        List<SysUser> userList = sysUserMapper.select(c->c);
        //System.out.println(userList);
        //ID 小于等于3
        userList = sysUserMapper.select(c->c.where(SysUserDynamicSqlSupport.userId,SqlBuilder.isGreaterThanWhenPresent(null)));
        System.out.println(userList);

    }

    @Test
    public void selectStatementProviderTest(){
        SelectStatementProvider selectStatement = select(SysUserDynamicSqlSupport.userId, SysUserDynamicSqlSupport.userName)
                .from(SysUserDynamicSqlSupport.sysUser,"u")
//                .rightJoin(OrderDynamicSqlSupport.order,"o")
//                .on(SysUserDynamicSqlSupport.userId,SqlBuilder.equalTo(OrderDynamicSqlSupport.userId))
                //isGreaterThanWhenPresent （不能直接空null，必须定义静态常量null）
                .where(SysUserDynamicSqlSupport.userId,SqlBuilder.isGreaterThanOrEqualTo(3).when(Objects::isNull))//the where clause should not render
                .build().render(RenderingStrategies.MYBATIS3);
        System.out.println(selectStatement.getSelectStatement());
        System.out.println(selectStatement.getParameters());
        System.out.println(sysUserMapper.selectMany(selectStatement));
//        List<Integer> numbers = Lists.newArrayList(1,2,3,4,5,6);
//        //var->lombok
//        var builder  = select(SysUserDynamicSqlSupport.userId, SysUserDynamicSqlSupport.userName)
//                .from(SysUserDynamicSqlSupport.sysUser)
//                .join(OrderDynamicSqlSupport.order)
//                .on(SysUserDynamicSqlSupport.userId,SqlBuilder.equalTo(OrderDynamicSqlSupport.userId))
//                .where();
//                if(Objects.nonNull(numbers)){
//                    builder .and(SysUserDynamicSqlSupport.userId,SqlBuilder.isIn(numbers));
//                }
//        builder.orderBy(SysUserDynamicSqlSupport.userId).fetchFirst(20).rowsOnly();
//        List<SysUser> userList = sysUserMapper.selectMany(builder .build().render(RenderingStrategies.MYBATIS3));
//        if(Objects.nonNull(userList)){
//            userList.forEach(u-> System.out.println(u));
//        }else{
//            System.err.println("结果为空");
//        }
    }
}
