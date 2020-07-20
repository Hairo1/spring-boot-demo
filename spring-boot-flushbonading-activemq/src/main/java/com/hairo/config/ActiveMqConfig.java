package com.hairo.config;

import com.hairo.config.listeners.SystemListener;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author ： Hairo
 * @date : 2020/3/3 10:30
 */
@Configuration
public class ActiveMqConfig {


    /**
     * 注册 Servlet 三大组件 之  Listner
     * 添加 ServletListenerRegistrationBean
     */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        /**ServletListenerRegistrationBean<T extends EventListener> 使用的是泛型，可以注册常见的任意监听器
         * 将自己的监听器注册进来*/
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean(new SystemListener());
        return registrationBean;
    }

    @Bean
    public Queue initQueue(){
        return new ActiveMQQueue("active.queue");
    }
}
