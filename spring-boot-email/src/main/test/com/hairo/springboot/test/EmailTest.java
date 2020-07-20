package com.hairo.springboot.test;

import com.hairo.springboot.service.SimpleEmailMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

/**
 * @author ： Hairo
 * @date : 2019/11/18 11:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public class EmailTest {

    @Autowired
    private SimpleEmailMessageService simpleEmailMessageService;

    /**
     * 发送文本邮件
     */
    @Test
    public void test(){
        simpleEmailMessageService.sendSimpleMail("收件人","黑客入侵...","小姐姐盗取中......","抄送邮箱(可不传改参数)","抄送1邮箱(可不传改参数)","抄送2邮箱(可不传改参数)");
        
        log.info("消息发送完成...");
    }

    /**
     * 发送HTML邮件
     */
    @Test
    public void sendHtmlEmail(){
        try {
            String  html  ="<!doctype html>\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "    <title>Hello, Bootstrap Table!</title>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "    <table fake-data-toggle=\"table\" id=\"table\">\n" +
                    "      <thead>\n" +
                    "        <tr>\n" +
                    "          <th>Item ID</th>\n" +
                    "          <th>Item Name</th>\n" +
                    "          <th>Item Price</th>\n" +
                    "        </tr>\n" +
                    "      </thead>\n" +
                    "      <tbody>\n" +
                    "        <tr>\n" +
                    "          <td>1</td>\n" +
                    "          <td>Item 1</td>\n" +
                    "          <td>$1</td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "          <td>2</td>\n" +
                    "          <td>Item 2</td>\n" +
                    "          <td>$2</td>\n" +
                    "        </tr>\n" +
                    "      </tbody>\n" +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>";
            simpleEmailMessageService.sendHtmlMail("收件人","黑客入侵...",html,"抄送1邮箱(可不传改参数)","抄送2邮箱(可不传改参数)");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        log.info("消息发送完成...");
    }

    /**
     * 发送带附近的邮件
     */
    @Test
    public void sendAttachmentsMail(){
        String  html  ="<!doctype html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <title>Hello, Bootstrap Table!</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <table fake-data-toggle=\"table\" id=\"table\">\n" +
                "      <thead>\n" +
                "        <tr>\n" +
                "          <th>Item ID</th>\n" +
                "          <th>Item Name</th>\n" +
                "          <th>Item Price</th>\n" +
                "        </tr>\n" +
                "      </thead>\n" +
                "      <tbody>\n" +
                "        <tr>\n" +
                "          <td>1</td>\n" +
                "          <td>Item 1</td>\n" +
                "          <td>$1</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>2</td>\n" +
                "          <td>Item 2</td>\n" +
                "          <td>$2</td>\n" +
                "        </tr>\n" +
                "      </tbody>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>";
        try {
            simpleEmailMessageService.sendAttachmentsMail("收件人","黑客入侵...",html,"附件路径","抄送邮箱(可不传改参数)");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        log.info("消息发送完成...");
    }

    /**
     *发送正文中有静态资源的邮件
     */
    @Test
    public void sendResourceMail() throws MessagingException {
        String imgName="hairo";
        String path = "C:\\Users\\Hairo\\Desktop\\"+imgName+".jpg";
        String content="<html><body>黄大爷：<br/><img src=\'cid:"+imgName+"\'></body></html>";
        simpleEmailMessageService.sendResourceMail("收件人","黑客入侵...",content,path,imgName,"抄送邮箱(可不传改参数)");
        log.info("消息发送完成...");
    }
}
