package com.hairo.springbootjava8demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Hairo
 * @date 2020/7/17 9:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String userName;

    private String pwd;

    private Integer userId;

    private Integer age;

    private String sex;

}
