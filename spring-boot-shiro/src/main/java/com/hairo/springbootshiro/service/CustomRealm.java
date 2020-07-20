package com.hairo.springbootshiro.service;

import com.google.common.collect.Lists;
import com.hairo.springbootshiro.entity.Permissions;
import com.hairo.springbootshiro.entity.SysUser;
import com.hairo.springbootshiro.entity.UserRole;
import com.hairo.springbootshiro.mappers.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Hairo
 * @date 2020/7/18 21:58
 */
@Service
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private PermissionsMapper permissionsMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        SelectStatementProvider statementProvider = SqlBuilder.select(PermissionsDynamicSqlSupport.permissionsName,SysUserDynamicSqlSupport.userId,
                SysUserDynamicSqlSupport.roleId, UserRoleDynamicSqlSupport.roleId, UserRoleDynamicSqlSupport.roleName)
                .from(SysUserDynamicSqlSupport.sysUser)
                .join(UserRoleDynamicSqlSupport.userRole)
                .on(SysUserDynamicSqlSupport.roleId, SqlBuilder.equalTo(UserRoleDynamicSqlSupport.roleId))
                .join(PermissionsDynamicSqlSupport.permissions)
                .on(PermissionsDynamicSqlSupport.roleId,SqlBuilder.equalTo(UserRoleDynamicSqlSupport.roleId))
                .where(SysUserDynamicSqlSupport.userName,SqlBuilder.isEqualTo(name))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        SysUser sysUserList = sysUserMapper.selectOne(statementProvider).orElseGet(SysUser::new);
        UserRole userRole = Optional.ofNullable(sysUserList.getUserRole()).orElseGet(UserRole::new);
        List<Permissions> permissionsList = Optional.ofNullable(userRole.getPermissionsList()).orElseGet(ArrayList::new);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole(userRole.getRoleName());
        //添加权限
        for (Permissions permissions :permissionsList) {
            simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsName());
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        SysUser user = sysUserMapper.selectOne(c->c.where(SysUserDynamicSqlSupport.userName,SqlBuilder.isEqualTo(name))).orElseGet(SysUser::new);
        if (Objects.isNull(name) || Objects.isNull(user.getUserPassword())) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getUserPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
