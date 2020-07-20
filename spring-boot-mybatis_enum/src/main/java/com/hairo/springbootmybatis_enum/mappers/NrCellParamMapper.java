package com.hairo.springbootmybatis_enum.mappers;

import com.hairo.springbootmybatis_enum.model.CellWorkParam;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ： Hairo
 * @date : 2020/3/26 16:52
 * 5G 基础工参
 */

public interface NrCellParamMapper {

    /**
     * 根据网元状态查询所有5G工参数据
     *
     * @param statusList 网元状态列表
     * @return 5G工参数据列表
     */
    List<CellWorkParam> selectAllNrCellParamByStatus(@Param("statusList") List<String> statusList);

    /**
     * 查询所有5G工参数据
     *
     * @return 5G工参数据列表
     */
    List<CellWorkParam> selectAllNrCellParam();

    /**
     * 批量插入5G工参
     *
     * @param cellWorkParamList 5G工参列表
     * @return TRUE/FALSE
     */
    Boolean batchInsertNrCellParam(@Param("cellWorkParamList") List<CellWorkParam> cellWorkParamList);

    /**
     * 删除旧5G工参数据
     *
     * @return TRUE/FALSE
     */
    Boolean deleteAllNrCellParam();

    /**
     * 查询上次5G工参入库的日期
     *
     * @return 日期
     */
    Date selectNrCellParamImportDate();
}
