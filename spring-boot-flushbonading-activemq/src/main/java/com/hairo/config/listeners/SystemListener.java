package com.hairo.config.listeners;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.broker.BrokerService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ： Hairo
 * @date : 2020/3/3 10:41
 */
@Slf4j
public class SystemListener implements ServletContextListener {
    /**
     * 应用启动时自动执行
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            log.info("应用启动......");
            /**设置 ActiveMQ 消息服务器用于被客户端连接的 url 地址,实际开发中，地址应该在配置文件中可配置，不要写死*/
            String serviceURL = "tcp://localhost:61616?alwaysSyncSend=true";
            /**BrokerService 表示 ActiveMQ 服务，每一个 BrokerService 表示一个消息服务器实例
             * 如果想启动多个，只需要 start 多个不同端口的 BrokerService 即可*/
            BrokerService brokerService = new BrokerService();
            //设置是否应将代理的服务公开到jmx中。默认是 true
            brokerService.setUseJmx(true);
            //为指定地址添加新的传输连接器
            brokerService.addConnector(serviceURL);
            /**启动 ActiveMQ 服务，此时客户端便可以使用提供的地址进行连接，然后发送消息过来，或者从这里消费消息。
             * 注意：这里内嵌启动后，默认是没有提供 8161 端口的 web 管理界面的，照样能做消息中间件使用*/
            brokerService.start();
            log.info("启动内嵌 ActiveMQ 服务器完成......");
        } catch (Exception e) {
            log.error("启动内嵌 ActiveMQ 服务器失败...");
        }
    }
    /**应用销毁时自动执行*/
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("ActiveMQ 应用关闭......");
    }
}
