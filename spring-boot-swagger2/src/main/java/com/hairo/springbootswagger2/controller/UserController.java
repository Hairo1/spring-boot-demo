package com.hairo.springbootswagger2.controller;

import com.hairo.springbootswagger2.data.GetPlanSuggestRequest;
import com.hairo.springbootswagger2.data.NrCellPlanCellRequest;
import com.hairo.springbootswagger2.pojo.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author ： Hairo
 * @date : 2020/1/10 9:22
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户请求接口")
@Slf4j
public class UserController {

    @ApiOperation(value = "根据用户名称获取用户", notes = "接口发布说明", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String")
    @ApiResponses({
            //401 - 403 ----
            @ApiResponse(code = 404, message = "用户名称不存在")
    })
    @GetMapping("/find-user/{userName}")
    public User getUser(@PathVariable String userName) {
        log.info("get user by username {}", userName);
        return User.builder().userName(userName).age(18).sex("🚹").build();
    }


    @ApiOperation(value = "根据用户名称删除用户", notes = "接口发布说明", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String")
    @ApiResponses({
            //401 - 403 ----
            @ApiResponse(code = 404, message = "用户名称不存在")
    })
    @DeleteMapping("/find-user/{userName}")
    public User delUser(@PathVariable String userName) {
        log.info("del user by username {}", userName);
        return User.builder().userName(userName).age(18).sex("🚹").build();
    }

    @ApiOperation(value = "添加用户", notes = "接口发布说明", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String")
    @ApiResponses({
            //401 - 403 ----
            @ApiResponse(code = 404, message = "用户名称已存在")
    })
    @PostMapping("/find-user/{userName}")
    public User addUser(@ApiParam(name = "planCellRequest", value = "规划站工参列表", required = true) @RequestBody @Valid NrCellPlanCellRequest planCellRequest,
                        HttpServletRequest request) {
        return User.builder().userName("").age(18).sex("🚹").build();
    }

    @ApiOperation(value = "根据用户名称修改用户", notes = "接口发布说明", produces = "application/json;charset=UTF-8")
    @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataType = "String")
    @ApiResponses({
            //401 - 403 ----
            @ApiResponse(code = 404, message = "用户名称不存在")
    })
    @PutMapping("/find-user/{userName}")
    public User updateUser(@PathVariable String userName) {
        log.info("update user by username {}", userName);
        return User.builder().userName(userName).age(18).sex("🚹").build();
    }


}
