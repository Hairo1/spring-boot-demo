package com.hairo.springBootMybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ： Hairo
 * @date : 2019/11/18 16:39
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnrResult implements Serializable {

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 源小区
     */
    private String sourceCgi;

    /**
     * 目标小区
     */
    private String targetCgi;

    /**
     * 站间距
     */
    private Double cellDistance;

    /**
     * 平均切换次数
     */
    private Integer averageSwitchingTimes;

    /**
     * 切换成功率
     */
    private Double switchingSuccessRate;

    /**
     * RSRP差值
     */
    private Double rsrpDifferential;

    /**
     * 小区对的MR采样点数
     */
    private Integer samplingNumber;

    /**
     * MR采样点占比
     * 自定义=MR中，主小区=源小区，目标小区CGI的采样点/源小区的采样点总数
     */
    private Double mrSamplingPercent;

    /**
     * 错误输出描述
     */
    private String description;

    /**
     * 平均站间距
     */
    private Double avgSpacing;

    /**
     * 频点+PCI匹配个数
     */
    private Integer poIntPciSize;

    /**
     * 频点+PCI小区匹配不唯一时两个小区到源小区的距离差
     */
    private Double doubleCellGoSourceDistDiff;

    /**
     * 目标小区2CGI(椭圆内的C3点或小区匹配不唯一时的小区2))
     */
    private String targetTwoCwp;


    /**
     * 目标小区名称
     */
    private String targetCellName;

    /**
     * 源小区名称
     */
    private String sourceCellName;

    /**
     * 片区名称
     */
    private String zoneName;

    /**
     * 片区ID
     */
    private Integer zoneId;


}
