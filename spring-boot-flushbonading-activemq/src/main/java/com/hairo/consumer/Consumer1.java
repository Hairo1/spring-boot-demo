package com.hairo.consumer;

import com.hairo.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author ： Hairo
 * @date : 2020/3/2 10:28
 */
@Component
@Slf4j
public class Consumer1 {

    @JmsListener(destination = "active.queue?consumer.dispatchAsync=false")
    public void receiveQueueMessage(List<SysUser> sysUser)  {
        try {
            for(SysUser sysUser1 : sysUser) {
                log.debug("消费者1接收到的消息:{}", sysUser1.getUsername());
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

//    @JmsListener(destination = "active.queue?consumer.dispatchAsync=false")
//    public void receiveQueueMessage1(SysUser sysUser)  {
//        try {
//            log.debug("消费者2接收到的消息:{}", sysUser.getUsername());
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//    }
//    @JmsListener(destination = "active.queue?consumer.dispatchAsync=false")
//    public void receiveQueueMessage2(SysUser sysUser)  {
//        try {
//            log.debug("消费者3接收到的消息:{}", sysUser.getUsername());
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//    }
//    @JmsListener(destination = "active.queue?consumer.dispatchAsync=false")
//    public void receiveQueueMessage4(SysUser sysUser)  {
//        try {
//            log.debug("消费者4接收到的消息:{}", sysUser.getUsername());
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//    }
}
