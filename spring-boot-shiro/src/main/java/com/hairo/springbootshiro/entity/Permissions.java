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
public class Permissions implements Serializable {
    private Integer permissionsId;

    private Integer roleId;

    private String permissionsName;

    private static final long serialVersionUID = 1L;
}