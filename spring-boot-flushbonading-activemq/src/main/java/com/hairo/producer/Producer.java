package com.hairo.producer;

import com.google.common.collect.Lists;
import com.hairo.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/3/2 10:23
 */
@Service
@Slf4j
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue queue;
    /**
     * 发送消息到指定队列
     * @param message 消息
     */
    public void sendMessage( String message) {
        try {
            List<SysUser> list = Lists.newArrayList();
            for(int i = 0; i < 300000; i++) {
                SysUser sysUser = new SysUser();
                sysUser.setAge(1);
                sysUser.setPassword("412");
                sysUser.setUsername(message+i);
                list.add(sysUser);
            }
            jmsTemplate.convertAndSend(queue, list);
            System.out.println("发送完成");

        } catch (JmsException e) {
            log.error(e.getMessage());
        }
    }
}
