package com.hairo.springbootasync.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ： Hairo
 * @date : 2020/6/14 23:26
 */
@Slf4j
public class BusinessService {

    public String testTask() throws Exception {
        try {
            for(int i = 0; i < 10; i++){
                System.out.println("业务执行-->"+i);
                Thread.sleep(100);
            }
            System.out.println("BusinessService OK");
            int i = 1 / 0;
        } catch (Exception e) {
            System.err.println("BusinessService ERROR->" + e.getMessage());
            throw  e;
        }

        return "BusinessService->OK";
    }
}
