package com.hairo.springbootasync;

import com.hairo.springbootasync.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class SpringBootAsyncApplicationTests {

    @Autowired
    private TaskService taskService;

    @Test
    public  void contextLoads() throws InterruptedException {
        taskService.startTask();
        Thread.sleep(1000 * 2);
    }

}
