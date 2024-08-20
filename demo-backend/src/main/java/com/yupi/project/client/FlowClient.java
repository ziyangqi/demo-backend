package com.yupi.project.client;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.pojo.dto.AuthDTO;
import com.yupi.project.common.pojo.dto.TaskAgreeDTO;
import com.yupi.project.common.pojo.dto.TaskRejectDTO;
import com.yupi.project.common.pojo.dto.TaskTransferDTO;
import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "flow-api",url = "${feign.flow.url}")
public interface FlowClient {
    @PostMapping("/auth/token")
    BaseResponse<String> authToken(@RequestBody AuthDTO authDTO);
    @PostMapping("/flow/agree")
    BaseResponse agreeFlow(@RequestBody TaskAgreeDTO agreeDTO);
    @PostMapping("/flow/reject")
    BaseResponse rejectFlow(@RequestBody TaskRejectDTO taskRejectDTO);
    @PostMapping("/flow/cancel/{procId}")
    BaseResponse cancelFlow(@PathVariable String procId, @RequestBody CallbackDTO callbackDTO);
    @PostMapping("/flow/transfer")
    BaseResponse transferFlow(@RequestBody TaskTransferDTO transferDTO);
}
