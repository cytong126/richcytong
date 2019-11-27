package com.wang.boot.pt.parttimes.administrator.controller;

import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.administrator.service.AdministratorService;
import com.wang.boot.pt.parttimes.main.bean.CookieConstants;
import com.wang.boot.pt.parttimes.main.bean.RedisConstants;
import com.wang.boot.pt.parttimes.main.enums.SysErrorEnum;
import com.wang.boot.pt.parttimes.main.utils.CookieUtil;
import com.wang.boot.pt.parttimes.main.utils.MyMD5Pass;
import com.wang.boot.pt.parttimes.main.utils.ResultUtil;
import com.wang.boot.pt.parttimes.main.vo.ResultVO;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:32
 *@description:
 */
@RestController
@RequestMapping("/AdministratorLogin")
@Slf4j
public class AdministratorLoginController {

    @Autowired
    private AdministratorService service;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @PostMapping(value = "selectByCodePass")//@RequestBody HashMap<String, String> map ,
    public ResultVO<AdministratorDto> selectByCodePass(
            @RequestParam("code") String code ,
            @RequestParam("pass") String pass,
            HttpServletResponse response){

        //String code = map.get("code");
       // String pass = map.get("pass");
        System.out.println("进入selectByCodePass"+code+" "+pass);

        //pass加密
        pass = MyMD5Pass.thePassWordMD5Add(pass);
        //1.查找用户信息
        List<AdministratorDto> list = service.selectByCodePass(code,pass);
        if(list!=null && list.size()==1){
            String token = UUID.randomUUID().toString();
            Integer expire = RedisConstants.EXPIRE;

            //2.存放redis
            stringRedisTemplate.opsForValue()
                    .set(String.format(RedisConstants.PREFIX , token)
                            , code , expire , TimeUnit.SECONDS);
            //3.存放cookie
            CookieUtil.set(response , CookieConstants.TOKEN , token , expire);
            return ResultUtil.success(list.get(0));
        }else{
            log.error("【登录失败】"+SysErrorEnum.LOGIN_NOTFOUND.getMsg() +" code={}" , code);
            return ResultUtil.error(SysErrorEnum.LOGIN_NOTFOUND);
        }
    }

    @PostMapping(value = "logout")//@RequestBody HashMap<String, String> map ,
    public ResultVO<String> logout(HttpServletRequest request,
                                   HttpServletResponse response){
        //1.查找cookie
        Cookie cookie = CookieUtil.get(request , CookieConstants.TOKEN);
        if(null != cookie) {
            //2.清除redis
            stringRedisTemplate.opsForValue().getOperations()
                    .delete(String.format(RedisConstants.PREFIX , cookie.getValue()));

            //3.清除cookie
            CookieUtil.set(response , CookieConstants.TOKEN , null , 0);
            return ResultUtil.success();
        }else{
            return ResultUtil.error(SysErrorEnum.LOGOUT_ERROR);
        }
    }




}
