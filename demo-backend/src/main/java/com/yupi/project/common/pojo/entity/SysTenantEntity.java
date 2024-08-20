package com.yupi.project.common.pojo.entity;

import lombok.Data;

@Data
public class SysTenantEntity {
    private Integer id;
    private String appid;
    private String tenantId;
    private String secret;
    private String salt;
}
