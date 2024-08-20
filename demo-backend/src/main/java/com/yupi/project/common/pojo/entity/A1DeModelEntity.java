package com.yupi.project.common.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class A1DeModelEntity {
    private Long id;
    private String name;
    private String modelKey;
    private String description;
    private Integer modelComment;
    private Date created;
    private String createdBy;
    private Date lastUpdated;
    private String lastUpdatedBy;
    private Integer version;
    private String typeId;
    private String typeKey;
    private String status;
    private Integer modelType;
    private String designer;
    private String defId;
    private String defKey;
    private String deployId;
    private Integer mainProcess;
    private String reason;
    private String tenantId;
    private String adminInfo;
    private String active;
    private String deleted;
    private byte[] thumbnail;
    private byte[] modelEditorXml;
    private byte[] dueDateModelJson;
    private byte[] formJson;
    private byte[] nodeAdminSetting;
    private byte[] extJson;
    private byte[] extSequenceJson;
    private byte[] extTaskJson;
    private byte[] extTaskExpireJson;
    private byte[] extTaskSkipJson;
    private byte[] extBackModelJson;
    private byte[] extTaskFormNodeJson;
}
