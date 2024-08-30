package com.yupi.project.controller;

import com.yupi.project.annotation.AutoFill;
import com.yupi.project.client.FlowClient;
import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.common.pojo.dto.TaskAgreeDTO;
import com.yupi.project.common.pojo.dto.TaskRejectDTO;
import com.yupi.project.common.pojo.dto.TaskTransferDTO;
import com.yupi.project.common.pojo.dto.TodoTaskQueryDTO;
import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.util.TokenThreadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("flow")
public class FlowController {
    private static final ConcurrentHashMap<Long, BaseResponse<String>> responseConcurrentHashMap = new ConcurrentHashMap<>();
    @Autowired
    private FlowClient flowClient;
    /**
     * 通过
     */
    @AutoFill
    @PostMapping("/agree")
    public BaseResponse<String> agree(@RequestBody @NotNull TaskAgreeDTO taskAgreeDTO){
        BaseResponse result = flowClient.agreeFlow(taskAgreeDTO);
        if(result.getCode() != 200){
            responseConcurrentHashMap.remove(taskAgreeDTO.getThreadId());
            return result;
        }
        return asyncGetResult(taskAgreeDTO.getThreadId());
    }

    /**
     * 驳回
     */
    @AutoFill
    @PostMapping("/reject")
    public BaseResponse reject(@RequestBody @NotNull TaskRejectDTO taskRejectDTO) {
        BaseResponse result = flowClient.rejectFlow(taskRejectDTO);
        if(result.getCode() != 200){
            responseConcurrentHashMap.remove(taskRejectDTO.getThreadId());
            return result;
        }
        return asyncGetResult(taskRejectDTO.getThreadId());
    }

    /**
     * 取消
     */
    @PostMapping("/cancel/{procId}")
    public BaseResponse cancel(@PathVariable @NotNull String procId) {
        CallbackDTO callbackDTO = new CallbackDTO();
        callbackDTO.setThreadId(Thread.currentThread().getId());
        BaseResponse result = flowClient.cancelFlow(procId,callbackDTO);
        if(result.getCode() != 200){
            responseConcurrentHashMap.remove(callbackDTO.getThreadId());
            return result;
        }
        return asyncGetResult(callbackDTO.getThreadId());
    }

    /**
     * 转办
     */
    @AutoFill
    @PostMapping("/transfer")
    public BaseResponse transfer(@RequestBody @NotNull TaskTransferDTO taskTransferDTO) {
        BaseResponse result = flowClient.transferFlow(taskTransferDTO);
        if(result.getCode() != 200){
            responseConcurrentHashMap.remove(taskTransferDTO.getThreadId());
            return result;
        }
        return asyncGetResult(taskTransferDTO.getThreadId());
    }
    @PostMapping("/callback/{threadId}")
    public BaseResponse callback(@RequestBody @NotNull BaseResponse baseResponse, @PathVariable Long threadId) {
        responseConcurrentHashMap.put(threadId, baseResponse);
        return ResultUtils.success(null);
    }

    // 查询流程引起代办的列表
    @PostMapping("/queryTaskList")
    public BaseResponse queryTaskList(@RequestBody @NotNull TodoTaskQueryDTO todoTaskQueryDTO) {
//        // 获得第一次查询的List

        BaseResponse todoTaskList = flowClient.getTodoTaskList(todoTaskQueryDTO);
        if (todoTaskList.getCode() != 200){
            throw new BusinessException("系统异常");
        }
        // 获取roleToken
        String roleToken = todoTaskQueryDTO.getRoleToken();
        // 设置roleToken
        TokenThreadUtil.setToken(roleToken);
        BaseResponse todoRoleTaskList = flowClient.getTodoTaskList(todoTaskQueryDTO);
        if (todoRoleTaskList.getCode() != 200){
            throw new BusinessException("系统异常");
        }
        List<Object> roleData = (ArrayList<Object>)todoRoleTaskList.getData();
        List<Object> data = (ArrayList<Object>)todoTaskList.getData();
        roleData.forEach(item -> {((LinkedHashMap<String, Object>)item).put("isTransfer", "false");});
        data.forEach(item -> {((LinkedHashMap<String, Object>)item).put("isTransfer", "true");});
        data.addAll(roleData);
        return ResultUtils.success(data);
    }


    private BaseResponse<String> asyncGetResult(Long threadId){
        BaseResponse<String> result;
        long startTime = System.currentTimeMillis();
        while(true){
            result = responseConcurrentHashMap.remove(threadId);
            if(result != null){
                break;
            }
            if (System.currentTimeMillis() - startTime > 4000) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "网络异常");
            }
        }
        return result;
    }
}
