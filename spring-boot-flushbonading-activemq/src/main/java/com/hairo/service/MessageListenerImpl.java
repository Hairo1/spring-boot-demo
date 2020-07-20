package com.hairo.service;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author ： Hairo
 * @date : 2020/3/3 1:08
 */

public class MessageListenerImpl implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
