package com.hairo.springbootshiro.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author ： Hairo
 *@date   ：2020/07/20 14:26
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    /**
     * 
     *   用户ID
     */
    private Integer userId;

    /**
     * 
     *   用户名
     */
    private String userName;

    /**
     * 
     *   密码
     */
    private String userPassword;

    /**
     * 
     *   年龄
     */
    private Integer userAge;

    /**
     * 
     *   地址
     */
    private String address;

    /**
     * 
     *   角色ID
     */
    private Integer roleId;

    private UserRole userRole;

    private static final long serialVersionUID = 1L;
}