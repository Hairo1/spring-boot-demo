package com.hairo.springBootMybatis.test.service.impl;

import com.hairo.springBootMybatis.test.entity.AnrThreshold;
import com.hairo.springBootMybatis.test.dao.AnrThresholdDao;
import com.hairo.springBootMybatis.test.service.AnrThresholdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AnrThreshold)表服务实现类
 *
 * @author Hairo
 * @since 2020-04-07 17:07:34
 */
@Service("anrThresholdService")
public class AnrThresholdServiceImpl implements AnrThresholdService {
    @Resource
    private AnrThresholdDao anrThresholdDao;

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public AnrThreshold queryById( ) {
        return this.anrThresholdDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AnrThreshold> queryAllByLimit(int offset, int limit) {
        return this.anrThresholdDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param anrThreshold 实例对象
     * @return 实例对象
     */
    @Override
    public AnrThreshold insert(AnrThreshold anrThreshold) {
        this.anrThresholdDao.insert(anrThreshold);
        return anrThreshold;
    }

    /**
     * 修改数据
     *
     * @param anrThreshold 实例对象
     * @return 实例对象
     */
    @Override
    public AnrThreshold update(AnrThreshold anrThreshold) {
        this.anrThresholdDao.update(anrThreshold);
        return this.queryById();
    }

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById( ) {
        return this.anrThresholdDao.deleteById() > 0;
    }
}