package com.hairo.springbootswagger2.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hairo.springbootswagger2.bean.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author ： Hairo
 * @date : 2020/3/27 13:03
 * 规划站工参实体类
 */
@ApiModel("规划站工参实体类")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanParam implements Serializable {

    /**
     * 主键自增ID
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String planId;

    /**
     * CGI
     */
    @JsonProperty(value = "cgi", required = true)
    @NotBlank(message = "新建站CGI不能为空")
    @ApiModelProperty(value = "新建站CGI", required = true)
    private String cgi;

    /**
     * 小区名称
     */
    @JsonProperty(value = "cell-name", required = true)
    @NotBlank(message = "新建站小区名称不能为空")
    @ApiModelProperty(value = "新建站名称", required = true)
    private String cellName;

    /**
     * 纬度
     */
    @NotNull(message = "新建站纬度不能为空")
    @JsonProperty(value = "latitude", required = true)
    @ApiModelProperty(value = "新建站纬度", required = true)
    private Double latitude;

    /**
     * 经度
     */
    @NotNull(message = "新建站经度不能为空")
    @JsonProperty(value = "longitude", required = true)
    @ApiModelProperty(value = "新建站经度", required = true)
    private Double longitude;

    /**
     * 特殊场景
     */
    @NotNull(message = "新建站特殊场景不能为空")
    @JsonProperty(value = "cover-scene-type", required = true)
    @ApiModelProperty(value = "新建站特殊场景", required = true)
    private SceneType sceneType;

    /**
     * 站型
     */
    @NotNull(message = "新建站站型不能为空")
    @JsonProperty(value = "cell-type", required = true)
    @ApiModelProperty(value = "新建站站型", required = true)
    private CellType cellType;

    /**
     * 区域类型
     */
    @NotNull(message = "新建站区域类型不能为空")
    @JsonProperty(value = "area-type", required = true)
    @ApiModelProperty("新建站区域类型")
    private AreaType areaType;

    /**
     * 厂家
     */
    @NotNull(message = "新建站厂家不能为空")
    @JsonProperty(value = "vendor", required = true)
    @ApiModelProperty(value = "新建站厂家", required = true)
    private Vendor vendor;

    /**
     * 地市
     */
    @NotNull(message = "新建站所属地市不能为空")
    @JsonProperty(value = "city", required = true)
    @ApiModelProperty(value = "新建站所属地市", required = true)
    private City city;

    /**
     * 天线角度
     */
    @JsonProperty(value = "azimuth", required = true)
    @NotNull(message = "新建站天线角度不能为空")
    @ApiModelProperty(value = "新建站天线角度", required = true)
    private Integer azimuth;

    /**
     * 数据入库时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date importTime;

    /**
     * 基站名称
     */
    @JsonProperty("gnodeb-name")
    @ApiModelProperty("新建站基站名称")
    private String gnodebName;

    /**
     * 带宽
     */
    @JsonProperty("bandwidth")
    @ApiModelProperty("新建站带宽")
    private String bandwidth;

    /**
     * PCI
     */
    @ApiModelProperty(hidden = true, value = "pci")
    @JsonIgnore
    private Integer pci;

    /**
     * 频点
     */
    @JsonProperty("freq-point")
    @ApiModelProperty("新建站频点")
    private Integer freqPoint;

    /**
     * 频段
     */
    @ApiModelProperty(hidden = true, value = "freq")
    @JsonIgnore
    private String freq;

    /**
     * 网元状态
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private String state;

    /**
     * 工单流水号
     */
    @ApiModelProperty(hidden = true, value = "plan-ep")
    @JsonIgnore
    private String planEp;

    /**
     * 组网形式
     */
    @JsonProperty("architecture")
    @NotNull(message = "新建站组网形式不能为空")
    @ApiModelProperty(value = "新建站组网形式(NSA/SA)", required = true)
    private Architecture architecture;

    /**
     * 新建站状态
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private PlanCellStation planCellStation;

    /**
     * 新建站激活时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date activeTime;

    /**
     * 新建站配置时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date configureTime;


    /**
     * 用户名称
     */
    @ApiModelProperty(hidden = true, value = "用户名称")
    @JsonProperty("user-name")
    private String userName;

    /**
     * 新建站接收方式
     */
    @ApiModelProperty(hidden = true, value = "新建站接收方式（流程引擎/界面）")
    @JsonProperty("accept-way")
    private String acceptWay;

    /**
     * 数据仓库工参入库的时间
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private Date useTime;

    /**
     * 所属网格
     */
    @JsonProperty("grid")
    @ApiModelProperty("所属网格")
    private String grid;

    /**
     * 所属区县
     */
    @ApiModelProperty(hidden = true, value = "county")
    @JsonIgnore
    private String county;

    /**
     * 网络制式
     */
    @ApiModelProperty(hidden = true, value = "net-work-type")
    @JsonIgnore
    private String networkType;


    /**
     * 组网形式中文值/枚举值互转
     *
     * @param architecture 中文值
     */
    public void setArchitecture(String architecture) {
        try {
            if (Objects.nonNull(architecture)) {
//                this.architecture = CommonUtil.isContainChinese(architecture.toString()) ? ChineseAndEnumTurnUtil.getPatternEnum(architecture.toString()) :
//                        Architecture.valueOf(architecture.toString());
            } else {
                this.architecture = Architecture.Unknown;
            }

        } catch (Exception e) {
            this.architecture = Architecture.Unknown;
        }
    }

    /**
     * 小区覆盖范围中文值/枚举值互转
     *
     * @param cellType 中文值
     */
    public void setCellType(String cellType) {
        try {
            if (Objects.nonNull(cellType)) {
                //this.cellType = CommonUtil.isContainChinese(cellType) ? ChineseAndEnumTurnUtil.getStationTypeEnum(cellType) : CellType.valueOf(cellType);
            } else {
                this.cellType = CellType.Unknown;
            }
        } catch (IllegalArgumentException e) {
            this.cellType = CellType.Unknown;
        }
    }

    /**
     * 中文地市/枚举互转
     *
     * @param city 中文值
     */
    public void setCity(String city) {
        try {
            if (Objects.nonNull(city)) {
                //this.city = CommonUtil.isContainChinese(city.toString()) ? ChineseAndEnumTurnUtil.getShortCityEnum(city.toString()) : City.valueOf(city.toString());
            } else {
                this.city = City.Unknown;
            }
        } catch (IllegalArgumentException e) {
            this.city = City.Unknown;
        }

    }

    /**
     * 中文供应商/枚举互转
     *
     * @param vendor 中文值
     */
    public void setVendor(String vendor) {
        try {
            if (Objects.nonNull(vendor)) {
                //this.vendor = CommonUtil.isContainChinese(vendor) ? ChineseAndEnumTurnUtil.getVendorEnum(vendor) : Vendor.valueOf(vendor);
            } else {
                this.vendor = Vendor.Unknown;
            }
        } catch (IllegalArgumentException e) {
            this.vendor = Vendor.Unknown;
        }
    }

    /**
     * 中文特殊场景/枚举互转
     *
     * @param sceneType 中文值
     */
    public void setSceneType(String sceneType) {
        try {
            if (Objects.nonNull(sceneType)) {
               // this.sceneType = CommonUtil.isContainChinese(sceneType) ?
                     //   ChineseAndEnumTurnUtil.getSceneEnum(sceneType) : SceneType.valueOf(sceneType);
            } else {
                this.sceneType = SceneType.GeneralScene;
            }
        } catch (IllegalArgumentException e) {
            this.sceneType = SceneType.GeneralScene;
        }
    }

    /**
     * 中文区域/枚举互转
     *
     * @param areaType 中文值
     */
    public void setAreaType(String areaType) {
        try {
            if (Objects.nonNull(areaType)) {
                //this.areaType = CommonUtil.isContainChinese(areaType) ? ChineseAndEnumTurnUtil.getAreaEnum(areaType) : AreaType.valueOf(areaType);
            } else {
                this.areaType = AreaType.Unknown;
            }
        } catch (IllegalArgumentException e) {
            this.areaType = AreaType.Unknown;
        }
    }

}
