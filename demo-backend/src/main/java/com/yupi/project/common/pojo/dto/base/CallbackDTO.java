package com.yupi.project.common.pojo.dto.base;
import com.yupi.project.common.pojo.enums.CallbackType;
import lombok.Data;

@Data
public class CallbackDTO {
    private String type = "HTTP";
    private String url = "";
    private Long threadId;
}
