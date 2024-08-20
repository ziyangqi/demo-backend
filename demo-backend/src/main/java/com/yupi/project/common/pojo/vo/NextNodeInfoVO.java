package com.yupi.project.common.pojo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NextNodeInfoVO {
    private String taskId;
    private String taskName;
    private String nodeType;
    @JsonProperty("nodeUsers")
    private List<NodeUserVO> extObj;

//    @JsonIgnore
//    private List extObj;
}
