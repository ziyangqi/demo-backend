package com.yupi.project.common.pojo.dto;


import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import lombok.Data;

@Data
public class TaskAgreeDTO extends CallbackDTO {
    private String taskName;
    private String bpmVar;

    private String taskId;
    private String taskTitle;

    private String opinion;
    private String actionName = "agree";
    private String action = "agree";

    private String nodeType;
    private Integer nodeIndex;
    private String chooseNode;
    private String chooseNodeUser;

    private String formType;
    private String formData;

    private Integer priority;
    private Boolean monitor;
}
