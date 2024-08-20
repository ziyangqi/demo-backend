package com.yupi.project.common.pojo.vo;



import com.yupi.project.common.pojo.entity.TaskSpeedEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 获取当前流程的进度
 */
@Data
@Builder
public class TaskSpeedListVO {

    // xml 内容
    private String Xml;
    // 当前节点
    private String  running;
    // 已经审批的节点
    private String completed;
    // data数据
    private List<TaskSpeedEntity> data;
}
