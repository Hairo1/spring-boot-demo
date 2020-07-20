package com.hairo.springbootshiro.controller;

import com.hairo.springbootshiro.entity.SysUser;
import com.hairo.springbootshiro.mappers.SysUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author Hairo
 * @date 2020/7/18 22:17
 */
@RestController
public class LoginController {

    @Resource
    private SysUserMapper sysUserMapper;

    @RequestMapping("/login")
    public String login(SysUser user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getUserPassword()
        );


       // try {
            //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);

        //MyException异常类处理

//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");

//        } catch (AuthenticationException e) {
//            return "账号或密码错误！";
//        } catch (AuthorizationException e) {
//            return "没有权限";
//        }
        return "login success";
    }
    /**
     * 注解验角色和权限
     */
    //@RequiresRoles("admin")
    @RequiresPermissions("get")
    @GetMapping("/index")
    public String index() {
        return "index!";
    }
}
