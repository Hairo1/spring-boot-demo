package com.hairo.springBootMybatis.mappers;

import com.hairo.springBootMybatis.pojo.AnrResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： Hairo
 * @date : 2019/11/18 16:47
 */

public interface AnrResultMapper {

    /**
     * 根据任务ID 查询ANR结果
     * @param taskId 任务ID
     * @return ANRResult列表
     */
    List<AnrResult> selectResultList(@Param("taskId") String taskId);
}
