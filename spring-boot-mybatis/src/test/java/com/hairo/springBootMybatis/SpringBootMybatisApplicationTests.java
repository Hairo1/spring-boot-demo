package com.hairo.springBootMybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.hairo.springBootMybatis.pojo.AnrResult;
import com.hairo.springBootMybatis.service.AnrResultService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
//mapper.xml所在的包路径
@MapperScan("com.hairo.springBootMybatis.mappers")
@Slf4j
public class SpringBootMybatisApplicationTests {

    @Autowired
    private AnrResultService anrResultService;

    @Test
    public void test() {
        List<AnrResult> anrResults = anrResultService.selectResultList("");
        for (AnrResult anrResult :anrResults){
            log.debug("{}",anrResult);
        }



    }
}
