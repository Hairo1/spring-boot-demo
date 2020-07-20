package com.hairo.springboothttpclien;

import com.hairo.springboothttpclien.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHttpClientApplicationTests {
    @Autowired
    private TaskService taskService;

    @Test
    public void contextLoads() throws InterruptedException {
        String s = taskService.sendPostRequest("http://localhost:8080/test", "this body", "this apiToken");
        System.out.println("接口返回-"+s);
        Thread.sleep(10000L);
    }

}
