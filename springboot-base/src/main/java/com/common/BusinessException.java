package com.common;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private BusinessError businessError;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(BusinessErrorEnum businessErrorEnum){
        super();
        this.businessError = new BusinessError(businessErrorEnum);
    }

    public BusinessException(BusinessErrorEnum businessError,String errMsg){
        super();
        this.businessError = new BusinessError(businessError);
        this.businessError.setErrMsg(errMsg);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
