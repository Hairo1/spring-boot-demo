package com.hairo.springBootMybatis.mappers;

import com.hairo.springBootMybatis.pojo.AnrMrData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： Hairo
 */
public interface AnrMrDataMapper {


    /**
     * 根据片区Id查询所有MR数据
     *
     * @param zoneId 片区ID
     * @return MR对象列表
     */
    void selectMrDataByZone(@Param("zoneId")int zoneId);

}
