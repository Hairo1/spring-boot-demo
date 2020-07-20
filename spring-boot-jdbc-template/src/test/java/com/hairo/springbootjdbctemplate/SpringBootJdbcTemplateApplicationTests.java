package com.hairo.springbootjdbctemplate;

import com.hairo.springbootjdbctemplate.dao.UserDao;
import com.hairo.springbootjdbctemplate.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcTemplateApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        User user = User.builder().address("中国").age(55).password("Hairo").userId(001).userName("萌萌").build();
        Boolean insertResult = userDao.insertUser(user);
        System.out.println("插入结果->"+insertResult);
    }

}
