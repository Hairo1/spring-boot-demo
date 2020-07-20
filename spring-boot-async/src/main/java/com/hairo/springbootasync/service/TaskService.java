package com.hairo.springbootasync.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ： Hairo
 * @date : 2020/6/14 23:24
 */
@Service
@Slf4j
public class TaskService {

    @Autowired
    private TaskRunning taskRunning;

    public String startTask(){
        try {
             taskRunning.startTask();
            System.out.println("TaskService OK");
        } catch (Exception e){
            System.err.println("TaskService ERROR->" + e.getMessage());
        }
        return "";
    }
}
