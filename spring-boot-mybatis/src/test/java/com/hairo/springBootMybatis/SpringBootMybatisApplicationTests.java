package com.hairo.springBootMybatis;


import com.hairo.springBootMybatis.pojo.AnrResult;
import com.hairo.springBootMybatis.service.AnrResultService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootMybatisApplicationTests {

    @Autowired
    private AnrResultService anrResultService;

    @Test
    public void test() {
        List<AnrResult> anrResults = anrResultService.selectResultList("f8c832bb-9a95-4a80-aa15-2dc6faad5f85");
        for (AnrResult anrResult :anrResults){
            log.debug("{}",anrResult);
        }



    }
}
