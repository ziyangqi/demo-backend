package com.yupi.project.common.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yupi.project.common.pojo.dto.base.BaseBo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copy 流程引擎系统的内容TodoTask的实体作为传参。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "待办查询参数", description = "待办查询参数")
public class TodoTaskQueryDTO extends BaseBo {

    @ApiModelProperty(value = "结束时间")
    private String endTime = null;
    @ApiModelProperty(value = "开始时间")
    private String startTime = null;

//    private String token;

    private String roleToken;
}
