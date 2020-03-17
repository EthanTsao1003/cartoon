package edu.ethan.cartoon.controller.advice;

import edu.ethan.cartoon.controller.vo.ResponseVO;
import edu.ethan.cartoon.service.exception.DataAccessException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Administrator
 * @date 2019/12/10
 */
@RestControllerAdvice("edu.ethan.cartoon.controller")
public class ControllerAspect {

    @ExceptionHandler(DataAccessException.class)
    public ResponseVO handleDataAccessException(DataAccessException e){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        vo.setMessage(e.getMessage());
        return vo;
    }
}