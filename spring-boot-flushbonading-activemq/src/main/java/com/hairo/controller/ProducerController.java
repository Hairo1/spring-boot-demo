package com.hairo.controller;

import com.hairo.pojo.SysUser;
import com.hairo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ： Hairo
 * @date : 2020/3/2 13:25
 */

@RestController
public class ProducerController {

    @Autowired
    private Producer producer;

    @GetMapping("/{message}")
    public void createMessage(@PathVariable String message){

        producer.sendMessage(message);
    }
}
