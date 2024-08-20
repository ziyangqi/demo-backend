package com.yupi.project.common.pojo.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取流程实例的详细信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskEntityVO {
    // 当前流程id
    private String id;

    private String title;

    private String name;

    private String createTime;

    private String processDefinitionId;

    // 流程id
    private String processInstanceId;
}
