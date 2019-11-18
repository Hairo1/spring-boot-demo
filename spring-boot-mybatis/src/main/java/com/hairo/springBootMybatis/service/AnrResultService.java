package com.hairo.springBootMybatis.service;

import com.hairo.springBootMybatis.pojo.AnrResult;

import java.util.List;

/**
 * @author ： Hairo
 * @date : 2019/11/18 16:47
 */

public interface AnrResultService {

    /**
     * 根据任务ID 获取ANR结果
     * @param taskId 任务ID
     * @return ANRResult列表
     */
    List<AnrResult> selectResultList(String taskId);
}
