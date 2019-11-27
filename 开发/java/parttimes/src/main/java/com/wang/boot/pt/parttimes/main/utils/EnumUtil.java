package com.wang.boot.pt.parttimes.main.utils;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 14:49
 *@description:
 */

import com.wang.boot.pt.parttimes.main.enums.ICodeEnums;
import com.wang.boot.pt.parttimes.main.vo.StatusVO;

import java.util.ArrayList;
import java.util.List;

public class EnumUtil {

    /*
     * 此方法可以根据编码得到信息内容
     * */
    public static <T extends ICodeEnums>T getEnumsByCode(Integer code , Class<T> enums) {
        for(T e : enums.getEnumConstants()) {
            if( e.getCode() == code) {
                return e;
            }
        }
        return null;
    }


    public static <T extends ICodeEnums> List<StatusVO> getStatusVO( Class<T> enums) {
        List<StatusVO> list = new ArrayList<StatusVO>();
        for(T e : enums.getEnumConstants()) {
            StatusVO vo = new StatusVO();
            vo.setCode(e.getCode());
            vo.setMsg(e.getMsg());
            list.add(vo);
        }
        return null;
    }





}
