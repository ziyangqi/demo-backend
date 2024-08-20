package com.yupi.project.common.pojo.vo;


import com.yupi.project.common.pojo.entity.SysTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class A1DeModelDetailVO {
    private String modelId; // id
    private String defId; // DEF_ID
    private String external; // IS_EXTERNAL
    private String xml; // PAGE_FORM_JSON
    private SysTypeEntity sysTypeEntity; //
}
