package edu.ethan.cartoon.controller;

import edu.ethan.cartoon.controller.vo.ResponseVO;
import org.springframework.http.HttpStatus;

/**
 * @author wangl
 * @date 2019/11/14
 */
public class BaseController {

    protected <T> ResponseVO<T> success(T data){
        ResponseVO<T> vo = new ResponseVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    protected ResponseVO success(String message){
        ResponseVO vo = new ResponseVO();
        vo.setCode(HttpStatus.OK.value());
        vo.setMessage(message);
        return vo;
    }

    protected ResponseVO fail(Integer code){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        return vo;
    }

    protected ResponseVO fail(Integer code, String message){
        ResponseVO vo = new ResponseVO();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }
}
