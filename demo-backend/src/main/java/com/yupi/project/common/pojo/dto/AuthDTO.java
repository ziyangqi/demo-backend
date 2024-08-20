package com.yupi.project.common.pojo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {
    private String userId;
    private String appid;
    private String secret;
}
