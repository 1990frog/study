package com.common;

import lombok.Data;

@Data
public class BusinessError {
    private int errCode;
    private String errMsg;

    public BusinessError(BusinessErrorEnum businessErrorEnum){
        this.errCode = businessErrorEnum.getErrCode();
        this.errMsg = businessErrorEnum.getErrMsg();
    }
}
