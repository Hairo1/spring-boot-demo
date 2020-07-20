package com.hairo.springbootdrools.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ： Hairo
 * @date : 2020/4/7 21:56
 */
@Data
public class User implements Serializable {
    private String username;

    private Integer age;

    private String password;
}
