package com.wang.boot.pt.parttimes.main.utils;

import java.security.MessageDigest;
/*
 *@author: Wang He
 *@time: 2019/11/1 0001 16:48
 *@description:
 */

public class MyMD5Pass {


    public static String thePassWordMD5Add(String key){
        //'3','A','0', '2', '4', '5',  '7', '8', '9', 'F', 'B', 'C','6', 'D', 'E','1'
        char hexDigits[] = {
                '3','A','3', '4', '4', '5',  '7', 'A', '9', 'F', 'C', 'C','6', 'D', 'E','1'
        };

        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
//		String newPass = MyMD5Pass.thePassWordMD5Add("aaa123");//值与sqlGetKey相同

        String key = "admin";
        String nwe = MyMD5Pass.thePassWordMD5Add(key);
        System.err.println(nwe);
    }



}
