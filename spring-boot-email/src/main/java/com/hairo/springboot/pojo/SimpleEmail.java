package com.hairo.springboot.pojo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ： Hairo
 * @date : 2019/11/18 10:36
 */
@Data
public class SimpleEmail {

    /**
     * 服务器地址
     */
    @Value("${spring.mail.host}")
    private String host;

    /**
     * 端口
     */
    @Value("${spring.mail.port}")
    private Integer port;

    /**
     * 用户名
     */
    @Value("${spring.mail.username}")
    private String username;

    /**
     * 密码
     */
    @Value("${spring.mail.password}")
    private String password;
}
