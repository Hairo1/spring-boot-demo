package com.hairo.springbootcache.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Hairo
 * @date 2020/7/3 15:07
 */
@Data
public class User implements Serializable {
    private String userName;

    private String password;

    public User(){

    }
    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }
}
