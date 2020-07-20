package com.hairo.springBootMybatis.test.service;

import com.hairo.springBootMybatis.test.entity.AnrThreshold;
import java.util.List;

/**
 * (AnrThreshold)表服务接口
 *
 * @author Hairo
 * @since 2020-04-07 17:07:34
 */
public interface AnrThresholdService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    AnrThreshold queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AnrThreshold> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param anrThreshold 实例对象
     * @return 实例对象
     */
    AnrThreshold insert(AnrThreshold anrThreshold);

    /**
     * 修改数据
     *
     * @param anrThreshold 实例对象
     * @return 实例对象
     */
    AnrThreshold update(AnrThreshold anrThreshold);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById( );

}