package com.hairo.springBootMybatis.service.impl;

import com.google.common.collect.Lists;
import com.hairo.springBootMybatis.pojo.AnrMrData;
import com.hairo.springBootMybatis.service.AnrMrDataService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/3/12 14:51
 */

@Service
public class AnrMrDataServiceImpl implements AnrMrDataService {

    @Autowired
    private SqlSessionTemplate template;
    @Override
    public List<AnrMrData> selectMrDataByZone(int zoneId) {
        List<AnrMrData> anrMrDataList = Lists.newArrayList();
        template.select("com.hairo.springBootMybatis.mappers.AnrMrDataMapper.selectMrDataByZone",zoneId,
                resultContext -> anrMrDataList.add((AnrMrData)resultContext.getResultObject()));
        return anrMrDataList;
    }
}
