package com;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
@Slf4j
public class SpringBootFlushbonadingActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFlushbonadingActivemqApplication.class, args);
    }

    // jms.alwaysSyncSend=false&jms.useAsyncSend=true 异步发送 ， alwaysSyncSend=true系统将会忽略useAsyncSend设置的值都采用同步
    @Bean
    public JmsTemplate jmsTemplate(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setAlwaysSyncSend(true);
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(factory);
        jmsTemplate.setExplicitQosEnabled(true);
        jmsTemplate.setDeliveryMode(2);
        jmsTemplate.setDeliveryPersistent(false);
        return jmsTemplate;
    }


}
