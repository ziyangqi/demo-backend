package com.yupi.project.common.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yupi.project.common.pojo.entity.PreNodeInfo;
import com.yupi.project.common.pojo.enums.DelegationState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName(value = "ACT_RU_TASK",resultMap = "BaseResultMap")
public class TaskEntityDataVO implements Serializable {


    protected static final String[] columns = {"ID_", "EXECUTION_ID_", "PROC_INST_ID_", "PROC_DEF_ID_", "TASK_DEF_ID_", "NAME_",
            "PARENT_TASK_ID_", "DESCRIPTION_", "TASK_DEF_KEY_", "ASSIGNEE_", "PRIORITY_", "CREATE_TIME_", "DUE_DATE_", "CATEGORY_"
            , "SUSPENSION_STATE_", "TENANT_ID_"};

    public static final String DELETE_REASON_COMPLETED = "completed";
    public static final String DELETE_REASON_DELETED = "deleted";

    private static final long serialVersionUID = 1L;
    protected String id;
    protected String owner;
    protected String subject;
    protected int assigneeUpdatedCount; // needed for v5 compatibility
    protected String originalAssignee; // needed for v5 compatibility
    protected String assignee;
    protected Integer urgingFlag;
    protected Integer urgentFlag;

    protected DelegationState delegationState;

    protected String parentTaskId;
    @TableField(exist = false)
    protected String bizKey;
    @TableField(exist = false)
    protected String userId;
    @TableField(exist = false)
    protected List<PreNodeInfo> preNodeInfoList;
    @TableField(exist = false)
    protected String preNodeTaskName;

    protected String nowUserIds;

    protected String nowUserNames;

    @TableField(exist = false)
    protected String userName;
    @TableField(exist = false)
    protected String photo;
    @TableField(exist = false)
    protected Date startTimeDate;
    protected String name;
    protected String localizedName;
    protected String description;
    protected String localizedDescription;
    protected int priority = 50;
    protected Date createTime; // The time when the task has been created
    protected Date dueDate;
    //protected int suspensionState = SuspensionState.ACTIVE.getStateCode();
    protected String category;
    protected String categoryName;
    protected String taskTitle;
    protected String preUserName;
    protected String preOpinion;


    protected String executionId;
    protected String processInstanceId;
    protected String processDefinitionId;
    @TableField(value = "TASK_DEF_ID_")
    protected String taskDefinitionId;

    protected String scopeId;
    protected String subScopeId;
    protected String scopeType;
    protected String scopeDefinitionId;

    protected String taskDefinitionKey;
    protected String formKey;


    protected Date claimTime;

    //protected String tenantId = TaskServiceConfiguration.NO_TENANT_ID;

}
