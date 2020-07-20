package com.hairo.springBootMybatis.test.dao;

import com.hairo.springBootMybatis.test.entity.AnrThreshold;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AnrThreshold)表数据库访问层
 *
 * @author Hairo
 * @since 2020-04-07 17:07:33
 */
public interface AnrThresholdDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    AnrThreshold queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AnrThreshold> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param anrThreshold 实例对象
     * @return 对象列表
     */
    List<AnrThreshold> queryAll(AnrThreshold anrThreshold);

    /**
     * 新增数据
     *
     * @param anrThreshold 实例对象
     * @return 影响行数
     */
    int insert(AnrThreshold anrThreshold);

    /**
     * 修改数据
     *
     * @param anrThreshold 实例对象
     * @return 影响行数
     */
    int update(AnrThreshold anrThreshold);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );

}