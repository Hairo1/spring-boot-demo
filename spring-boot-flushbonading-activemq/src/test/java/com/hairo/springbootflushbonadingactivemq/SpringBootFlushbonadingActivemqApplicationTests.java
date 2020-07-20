package com.hairo.springbootflushbonadingactivemq;

import com.hairo.consumer.Consumer1;
import com.hairo.pojo.SysUser;
import com.hairo.producer.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJms
public class SpringBootFlushbonadingActivemqApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() {
       SysUser sysUser =  new SysUser();
       sysUser.setUsername("hairo");
        producer.sendMessage("");
        sysUser.setUsername("hairo1");
    }

}
