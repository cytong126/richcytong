package com.wang.boot.pt.parttimes.main.utils;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:15
 *@description:
 */

import com.wang.boot.pt.parttimes.main.enums.ResultEnum;
import com.wang.boot.pt.parttimes.main.enums.SysErrorEnum;
import com.wang.boot.pt.parttimes.main.vo.ResultVO;

public class ResultUtil {

    public static ResultVO success() {

        return success(null);
    }

    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.OK.getCode());
        resultVO.setMsg(ResultEnum.OK.getMsg());
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.ERROR.getCode());
        resultVO.setMsg(ResultEnum.ERROR.getMsg());
        return resultVO;
    }

    public static ResultVO error(SysErrorEnum enums) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(enums.getCode());
        resultVO.setMsg(enums.getMsg());
        return resultVO;
    }
    public static ResultVO error(Integer code) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        SysErrorEnum enums = EnumUtil.getEnumsByCode(code, SysErrorEnum.class);
        resultVO.setMsg(enums.getMsg());
        return resultVO;
    }

    public static ResultVO error(Integer code,String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
