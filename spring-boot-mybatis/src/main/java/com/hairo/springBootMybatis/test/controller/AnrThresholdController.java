package com.hairo.springBootMybatis.test.controller;

import com.hairo.springBootMybatis.test.entity.AnrThreshold;
import com.hairo.springBootMybatis.test.service.AnrThresholdService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AnrThreshold)表控制层
 *
 * @author Hairo
 * @since 2020-04-07 17:07:35
 */
@RestController
@RequestMapping("anrThreshold")
public class AnrThresholdController {
    /**
     * 服务对象
     */
    @Resource
    private AnrThresholdService anrThresholdService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AnrThreshold selectOne(int id) {
        return this.anrThresholdService.queryById();
    }

}