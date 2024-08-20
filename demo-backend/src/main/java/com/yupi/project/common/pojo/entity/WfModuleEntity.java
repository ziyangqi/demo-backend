package com.yupi.project.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


import java.nio.charset.StandardCharsets;
import java.util.Date;
@Data
@TableName("PANGU_WORKBENCH_WF_MODULE")
public class WfModuleEntity{
    @TableId(type = IdType.INPUT)
    private String id;

    private String name;

    private String code;

    private String parent;
    private String type;

    private String icon;
    private String bgColor;

    private String iconClass;
    @TableField(exist = false)
    private String modelName;
    private String authority;
    @TableField(exist = false)
    @JsonIgnore
    private byte[] authorityStr;

    private String description;

    private String nodeInfoType;

    private String nodeInfo;

    private String href;

    private String modelKey;

    private Byte disabled;

    private Date createTime;

    private String createUserId;

    private String createUserName;

    private Date updateTime;

    private String tenantId;

    public String getAuthority() {
        if (StringUtils.isEmpty(authority) && (this.authorityStr != null)) {
            authority = new String(this.authorityStr, StandardCharsets.UTF_8);
        }
        return authority;
    }

}
