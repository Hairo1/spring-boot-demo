package com.hairo.springboothttpclien.controller;

import com.hairo.springboothttpclien.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Timer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Hairo
 */
@RestController
public class TestController {

    private Semaphore semaphore = new Semaphore(1);

    @Autowired
    private  TaskService taskService;

    @PostMapping("/test")
    public String  receiverRequests(@RequestBody String json, HttpServletRequest request){
        //获取Header
        System.out.println(request.getHeader("apiToken"));
        System.out.println(request.getHeader("clientId"));
        //获取JSON
        System.out.println("json-"+json);
        return "OK";
    }

    @GetMapping("/")
    public String sendUrl(){
        String s = taskService.sendPostRequest("http://localhost:8080/test", "this body", "this apiToken");
        System.out.println("接口返回-"+s);
        return "接口返回-"+s;
    }

    @GetMapping("/request-limit")
    public String requestLimit() throws InterruptedException {
        if(semaphore.tryAcquire(10 * 1000)) {
            TimeUnit.SECONDS.sleep(10);
            semaphore.release();
            System.out.println("访问正常");
            return "访问正常";
        }
        System.out.println("被限流了");
        return "被限流了";
    }
}
