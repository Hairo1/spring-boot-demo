package com.hairo.springbootswagger2.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hairo.springbootswagger2.pojo.PlanParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author zhaoqiheng
 */
@Data
@ApiModel(value = "规划站邻区配置请求对象", description = "5G规划小区邻区配置请求对象，包含新建小区的批号，以及规划小区列表")
public class NrCellPlanCellRequest {

    @Valid
    @NotBlank(message = "任务编号不能为空")
    @ApiModelProperty(value = "任务编号", notes = "用来同返回结果中的任务编号对应，确定结果与申请的对应关系。同时当一个规划站多次出现在不同批次时，可以用来区分不用批次的数据。", required = true)
    private String id;

    @Valid
    @NotEmpty(message = "规划站列表不能为空")
    @ApiModelProperty(value = "规划站列表", notes = "需要用来配置邻区的新建小区列表", required = true)
    private List<PlanParam> planParams;

    /**
     * HTTP请求信息
     */
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    private HttpServletRequest request;
}
