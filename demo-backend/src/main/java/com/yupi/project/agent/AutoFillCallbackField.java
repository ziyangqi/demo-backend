package com.yupi.project.agent;

import com.yupi.project.common.pojo.dto.base.CallbackDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutoFillCallbackField {
    @Pointcut("execution(public * com.yupi.project.controller.FlowController.*(..)) && @annotation(com.yupi.project.annotation.AutoFill)")
    public void p() {}
    @Before("p()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args == null && args.length == 0) {
            return;
        }
        CallbackDTO callbackDTO = (CallbackDTO) args[0];
        callbackDTO.setThreadId(Thread.currentThread().getId());
    }
}
