package com.hairo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author ： Hairo
 * @date : 2020/3/2 10:28
 */

@Component
@Slf4j
public class Consumer2 {

  //  @JmsListener(destination = "test1")
    public void receiveQueueMessage(String text) {
        log.debug("消费者2接收到的消息:"+text);
    }
}