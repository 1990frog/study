package com.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 这种方法的优势是将500错误改成自定义异常，对前端友好
     *
     * @param servletRequest
     * @param httpServletResponse
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doError(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse, Exception ex) {
        if (ex instanceof BusinessException) {
            return Result.builder(ex, "error");
        } else if (ex instanceof NoHandlerFoundException) {
            return Result.builder(new BusinessError(BusinessErrorEnum.NO_HANDLER_FOUND_ERROR), "error");
        } else {
            return Result.builder(new BusinessError(BusinessErrorEnum.UNKNOW_ERROR), "error");
        }
    }
}
