package com.hairo.springbootjdbctemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @date 2020/6/28 15:50
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String userName;

    private String password;

    private Integer age;

    private Integer userId;

    private String address;
}
