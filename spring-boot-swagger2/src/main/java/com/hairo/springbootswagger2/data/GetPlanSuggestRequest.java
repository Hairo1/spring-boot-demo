package com.hairo.springbootswagger2.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hairo.springbootswagger2.bean.enums.Architecture;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ： Hairo
 * @date : 2020/5/19 14:57
 */
@Data
@ApiModel(value = "获取邻区配置数据",description = "可根据任务ID或者工单ID 与 组网类型查询类型配置数据")
public class GetPlanSuggestRequest {

    @JsonProperty(value = "id", required = true)
    @ApiModelProperty(value = "id", notes = "任务ID或者工单ID")
    private String id;

    @JsonProperty(value = "architecture", required = true)
    @ApiModelProperty(value = "组网形式", notes = "NSA和SA")
    private Architecture architecture;
}
