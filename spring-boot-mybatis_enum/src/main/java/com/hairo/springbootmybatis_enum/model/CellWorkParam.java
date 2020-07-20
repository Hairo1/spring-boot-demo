package com.hairo.springbootmybatis_enum.model;


import com.hairo.springbootmybatis_enum.code.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (CellWorkParam)实体类
 *
 * @author Hairo
 * @since 2020-03-26 16:50:42
 * 4G/5G通用基础工参
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CellWorkParam implements Serializable {
    private static final long serialVersionUID = -63299525811579485L;


    /**
     * CGI
     */
    private String cgi;

    /**
     * 小区名称
     */
    private String cellName;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 特殊场景
     */
    private SceneType sceneType;

    /**
     * 站型
     */
    private CellType cellType;

    /**
     * 区域类型
     */
    private AreaType areaType;

    /**
     * 厂家
     */
    private Vendor vendor;

    /**
     * 地市
     */
    private City city;

    /**
     * 天线角度
     */
    private Integer azimuth;

    /**
     * 数据导入时间
     */
    private Date importTime;

    /**
     * 基站名称
     */
    private String gnodebName;

    /**
     * PCI
     */
    private Integer pci;

    /**
     * 频点
     */
    private Integer freqPoint;

    /**
     * 频段
     */
    private String freq;

    /**
     * 网元状态
     */
    private String state;

    /**
     * 工单流水号
     */
    private String planEp;

    /**
     * 数据仓库工参入库的时间
     */
    private Date useTime;

    /**
     * 路测网格
     */
    private String grid;

    /**
     * 所属区县
     */
    private String county;

    /**
     * 网络制式
     */
    private String networkType;

}