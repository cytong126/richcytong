package com.wang.boot.pt.parttimes.main.vo;

import lombok.Data;

/*
 *@author: Wang He
 *@time: 2019/11/7 0007 15:22
 *@description:
 */
@Data
public class StatusVO<T> {
    private T code;
    private String msg;

}
