package com.hairo.springbootswagger2.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hairo.springbootswagger2.UserType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/1/10 9:18
 */
@ApiModel("用户实体类")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户年龄")
    private Integer age;

    @JsonIgnore
    @ApiModelProperty("用户性别")
    private String sex;

    @NotNull
    @ApiModelProperty("UserType")
    private UserType userType;

    @ApiModelProperty("planParams")
    private List<PlanParam> planParams;

    public void setUserType(String ss) {
        System.out.println(ss);
    }
}
