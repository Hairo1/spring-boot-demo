package com.hairo.springbootshiro.entity;

import java.io.Serializable;
import java.util.List;

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
public class UserRole implements Serializable {
    private Integer roleId;

    private String roleName;

    private List<Permissions> permissionsList;

    private static final long serialVersionUID = 1L;
}