package com.wang.boot.pt.parttimes.main.handler;


import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.main.enums.SysErrorEnum;
import com.wang.boot.pt.parttimes.main.exception.AdminLoginException;
import com.wang.boot.pt.parttimes.main.exception.SysErrorException;
import com.wang.boot.pt.parttimes.main.utils.ResultUtil;
import com.wang.boot.pt.parttimes.main.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录校验异常统一处理类
 * Created by Administrator on 2017/11/6 0006.
 */
//@ControllerAdvice
@RestControllerAdvice
public class AdminLoginHandler {

    @ExceptionHandler(value = AdminLoginException.class)
    public ResultVO<AdministratorDto> handlerAuthorize() {
        System.out.println("进入handlerAuthorize");
        //1.返回未登录编码
        return ResultUtil.error(SysErrorEnum.NOT_LOGIN_ERROR);
    }

    @ExceptionHandler(SysErrorException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ResultVO handlerSellException(SysErrorException e) {
        return ResultUtil.error(e.getCode(),e.getMessage());
    }

}
