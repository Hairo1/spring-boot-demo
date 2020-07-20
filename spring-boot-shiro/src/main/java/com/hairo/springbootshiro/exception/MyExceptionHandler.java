package com.hairo.springbootshiro.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hairo
 * @date 2020/7/18 22:19
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    /**
     * 登录认证异常
     *
     * @return
     */
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    @ResponseBody
    public String authenticationException(Exception e) {
        log.error("登陆异常账号不存在或密码错误->{}",e.getMessage());
        return "登陆异常账号不存在或密码错误->"+e.getMessage();
    }



    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    @ResponseBody
    public String ErrorHandler(Exception e) {
        log.error("没有通过权限验证->{}",e.getMessage());
        return "没有通过权限验证->"+e.getMessage();
    }



}
