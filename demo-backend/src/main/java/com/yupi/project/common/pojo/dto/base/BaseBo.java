package com.yupi.project.common.pojo.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class BaseBo {
    @ApiModelProperty(value = "数量")
    //数量
    protected Integer limit=10;
    //页码
    @ApiModelProperty(value = "页码")
    protected Integer page=1;
}
