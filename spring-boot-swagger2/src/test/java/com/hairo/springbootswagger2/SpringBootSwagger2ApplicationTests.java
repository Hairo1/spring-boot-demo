package com.hairo.springbootswagger2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hairo.springbootswagger2.pojo.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;

@SpringBootTest
public class SpringBootSwagger2ApplicationTests {

    @Test
    public void contextLoads() throws JsonProcessingException {
        User user = new User();
        user.setUserName("Amy");
        user.setUserType("ss");
        System.out.println("-- before serialization --");
        System.out.println(user.getUserType().getDisplayName());

        System.out.println("-- after serialization --");
        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writeValueAsString(user);
        System.out.println(jsonString);
    }

}
