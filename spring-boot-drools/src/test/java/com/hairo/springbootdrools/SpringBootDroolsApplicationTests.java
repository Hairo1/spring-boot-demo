package com.hairo.springbootdrools;

import com.hairo.springbootdrools.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDroolsApplicationTests {

    @Autowired
    KieSession kieSession;

    @Test
    public void contextLoads() {
            User user = new User();
            user.setUsername("Hairo");
            user.setAge(111);
            kieSession.insert(user);
            kieSession.fireAllRules();
    }

}
