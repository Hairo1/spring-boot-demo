package com.hairo.springbootswagger2.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author ： Hairo
 * @date : 2020/1/10 9:18
 */
@ApiModel("用户实体类")
@Data
@Builder
public class User {

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @ApiModelProperty("用户性别")
    private String sex;
}
