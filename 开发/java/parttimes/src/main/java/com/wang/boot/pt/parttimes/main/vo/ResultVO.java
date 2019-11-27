package com.wang.boot.pt.parttimes.main.vo;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 14:51
 *@description:
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -4193252858593686870L;

    /** 状态码 0 表示成功 */
    private Integer code;

    /** 状态码说明 */
    private String msg;

    /** 返回数据*/
    private T data;


}
