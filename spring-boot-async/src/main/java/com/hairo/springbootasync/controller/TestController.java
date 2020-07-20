package com.hairo.springbootasync.controller;

import com.hairo.springbootasync.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： Hairo
 * @date : 2020/6/15 13:01
 */

@RestController
public class TestController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String test(){
        taskService.startTask();
        return "controller - ok";
    }
}
