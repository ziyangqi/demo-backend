package com.yupi.project.exception;

import com.yupi.project.common.ErrorCode;

/**
 * 自定义异常类
 *
 * @author yupi
 */
public class BusinessException extends RuntimeException {

    private  int code = 201;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }


    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
