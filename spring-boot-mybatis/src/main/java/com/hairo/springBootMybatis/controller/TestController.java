package com.hairo.springBootMybatis.controller;

import com.google.common.collect.Maps;
import com.hairo.springBootMybatis.mappers.AnrMrDataMapper;
import com.hairo.springBootMybatis.mappers.AnrResultMapper;
import com.hairo.springBootMybatis.mysqlmappers.ZoneMapper;
import com.hairo.springBootMybatis.pojo.AnrMrData;
import com.hairo.springBootMybatis.pojo.AnrResult;
import com.hairo.springBootMybatis.pojo.Zone;
import com.hairo.springBootMybatis.service.AnrMrDataService;
import com.hairo.springBootMybatis.service.AnrResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/3/10 18:22
 */

@RestController
public class TestController {

    @Autowired
    private ZoneMapper zoneMapper;
    @Autowired
    private AnrResultMapper anrResultMapper;
    @Autowired
    private AnrMrDataService anrMrDataService;

    @GetMapping("/{zoneId}")
    public void s(@PathVariable Integer zoneId){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        long start = System.currentTimeMillis();
        List<AnrMrData> anrMrData = anrMrDataService.selectMrDataByZone(zoneId);
        System.out.println("time->" + ((System.currentTimeMillis() - start) / 1000)+" S");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

}
