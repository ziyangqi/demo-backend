package com.yupi.project.common.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FormDetailVO {
    private String account;
    private String userName;
    private String userNo;
    private String formJson;
}
