package com.yupi.project.common.pojo.dto;

import lombok.Data;

import java.util.List;

@Data
public class AgentSettingDTO {
    private String agentType;

    private String startDate;
    private String endDate;

    private String subject;
    private String opinion;

    private List<String> authIds;



    private String id;
    private String authId;
    private String createBy;
    private String tenantId;
    private String CreateTime;
}
