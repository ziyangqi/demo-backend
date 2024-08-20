package com.yupi.project.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TaskStartVO {
    private String procId;
    private String taskTitle;
}
