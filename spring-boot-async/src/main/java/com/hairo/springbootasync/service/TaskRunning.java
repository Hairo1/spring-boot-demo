package com.hairo.springbootasync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author ： Hairo
 * @date : 2020/6/14 23:25
 */
@Component
@Slf4j
public class TaskRunning {

    @Async
    public Future<String> startTask(){
        String s = null;
        try {
            System.out.println("开始执行异步业务...");
            s = new BusinessService().testTask();
            System.out.println("异步方法执行完成");
        } catch (Exception e) {
            System.err.println("TaskRunning ERROR->" + e.getMessage());
        }
        return new AsyncResult<String>(s);
    }
}
