package com.lbhz.common.exception;

import com.lbhz.common.response.BaseResult;
import com.lbhz.common.response.BaseResultFactory;
import com.lbhz.common.response.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author ZhXiQi
 * @Title:
 * @date 2019/11/26 14:30
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResult handleBusinessException(BusinessException e) {
        log.error("业务异常，{}",e.getMsg());
        e.printStackTrace();
        return e.getBaseResult();
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleDefaultException(Exception e){
        log.error("系统出现异常，异常原因为：{}",e.getMessage());
        e.printStackTrace();
        return BaseResultFactory.produceResult(Code.ERROR,e.getMessage());
    }
}
