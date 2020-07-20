package com.hairo.springboothttpsjasypt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： Hairo
 * @date : 2020/6/15 21:47
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/")
    public String testRestController(){
        return "OK";
    }
}
