package com.hairo.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ： Hairo
 * @date : 2020/1/14 9:25
 */
@Data
public class User {
    @Value("${com.hairo.username}")
    private String username;
    @Value("${com.hairo.password}")
    private String password;
    @Value("${com.hairo.sex}")
    private String sex;
}
