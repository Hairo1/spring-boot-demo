package com.hairo.springBootMybatis.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： Hairo
 * @date : 2019/6/20 11:06
 */
@Data
@ToString
public class AnrMrData implements Serializable {

    /**
     * 源小区cgi
     */
    private String sourceCellCgi;

    /**
     * 目标小区频点
     */
    private Integer targetEarfcn;

    /**
     * 目标小区pci
     */
    private Integer targetPci;


    /**
     * 源小区频点
     */
    private Integer sourceEarfcn;

    /**
     * 源小区pci
     */
    private Integer sourcePci;

    /**
     * 源小区信号强度
     */
    private Double sourceRsrp;

    /**
     * 目标信号强度
     */
    private Double targetRsrp;

    /**
     * 采样数量
     */
    private Integer samplingNumber;

    /**
     * 信号强度差别
     */
    private Double rsrpDifferential;

    /**
     * 导入时间
     */
    private Date importTime;

    /**
     * 周期
     */
    private Date startTime;

}
