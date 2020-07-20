package com.hairo.springBootMybatis.service;

import com.hairo.springBootMybatis.pojo.AnrMrData;

import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/3/12 14:50
 */

public interface AnrMrDataService {

    /**
     * 根据片区Id查询所有MR数据
     *
     * @param zoneId 片区ID
     * @return MR对象列表
     */
    List<AnrMrData> selectMrDataByZone(int zoneId);
}
