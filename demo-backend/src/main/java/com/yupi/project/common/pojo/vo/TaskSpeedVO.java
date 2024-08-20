package com.yupi.project.common.pojo.vo;


import com.yupi.project.common.pojo.entity.TaskSpeedEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 获取流程进度信息
 */
@Data
@Builder
public class TaskSpeedVO {
    private List<TaskSpeedEntity> data;
    private String xml;
    private String completed;
    private String runing;
}
