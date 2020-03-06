package com.common;

import com.util.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public Result doError(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse, Exception ex) throws Exception {
        if (ex instanceof BusinessException) {
            return Result.builder(((BusinessException) ex).getBusinessError(), "error");
        } else if (ex instanceof NoHandlerFoundException) {
            return Result.builder(new BusinessError(BusinessErrorEnum.NO_HANDLER_FOUND_ERROR), "error");
        } else if (ex instanceof MethodArgumentNotValidException) {
            return Result.builder(new BusinessError(BusinessErrorEnum.PARAM_ERROR.getErrCode(),ErrorUtil.processErrorString(((MethodArgumentNotValidException) ex).getBindingResult())), "error");
        } else {
            throw ex;
//            return Result.builder(new BusinessError(BusinessErrorEnum.UNKNOW_ERROR), "error");
        }
    }
}
