package com.hairo.springBootMybatis.service.impl;

import com.hairo.springBootMybatis.mappers.AnrResultMapper;
import com.hairo.springBootMybatis.pojo.AnrResult;
import com.hairo.springBootMybatis.service.AnrResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： Hairo
 * @date : 2019/11/18 16:47
 */
@Service
public class AnrResultServiceImpl implements AnrResultService {

    @Autowired
    private AnrResultMapper anrResultMapper;
    @Override
    public List<AnrResult> selectResultList(String taskId) {
        return anrResultMapper.selectResultList(taskId);
    }
}
