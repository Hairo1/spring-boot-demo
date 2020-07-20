package com.hairo.springbootmybatis_enum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.hairo.springbootmybatis_enum.mappers")
public class SpringBootMybatisEnumApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisEnumApplication.class, args);
    }

}
