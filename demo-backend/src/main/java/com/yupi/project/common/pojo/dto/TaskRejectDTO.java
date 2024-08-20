package com.yupi.project.common.pojo.dto;


import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import lombok.Data;

@Data
public class TaskRejectDTO extends CallbackDTO {
    private String option;
    private String operate;

    private String taskId;
    private String taskTitle;

    private String priority;
    private String newActivityId;



    private String userId;
}
