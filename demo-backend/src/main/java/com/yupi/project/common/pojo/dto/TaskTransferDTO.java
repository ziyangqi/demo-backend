package com.yupi.project.common.pojo.dto;


import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import com.yupi.project.common.pojo.entity.UcUser;
import lombok.Data;

@Data
public class TaskTransferDTO extends CallbackDTO {

    private UcUser usersInfo;
    private String option;
    private String taskId;

}
