package com.action.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorEnum {
    // 错误类型10000开头
    UNKNOW_ERROR(10000,"未知异常"),
    LOGIN_ERROR(10001,"登录失败"),
    NO_HANDLER_FOUND_ERROR(10002,"找不到执行的路径操作"),
    PARAM_ERROR(10003,"参数错误");

    private Integer errCode;

    private String errMsg;

}
