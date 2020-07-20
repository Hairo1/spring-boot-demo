package com.hairo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ： Hairo
 * @date : 2020/3/2 13:32
 */
@Data
public class SysUser implements Serializable {

    private String username;
    private String password;
    private Integer age;
}
