package com.wang.boot.pt.parttimes.administrator.controller;

import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.administrator.service.AdministratorService;
import com.wang.boot.pt.parttimes.main.bean.CookieConstants;
import com.wang.boot.pt.parttimes.main.bean.RedisConstants;
import com.wang.boot.pt.parttimes.main.enums.SysErrorEnum;
import com.wang.boot.pt.parttimes.main.exception.SysErrorException;
import com.wang.boot.pt.parttimes.main.utils.CookieUtil;
import com.wang.boot.pt.parttimes.main.utils.ResultUtil;
import com.wang.boot.pt.parttimes.main.vo.ResultVO;
import com.wang.boot.pt.parttimes.partcategory.dto.PartCategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:32
 *@description:
 */
@RestController
@RequestMapping("/Administrator")
@Slf4j
public class AdministratorController {

    @Autowired
    private AdministratorService service;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping(value = "selectByCode")
    public ResultVO<AdministratorDto> selectByCode(HttpServletRequest request){
        System.out.println("进入selectByCode");
            Cookie cookie = CookieUtil.get(request , CookieConstants.TOKEN);
            String cookieValue = cookie.getValue();
        String code = stringRedisTemplate.opsForValue().get(String.format(RedisConstants.PREFIX , cookie.getValue()));


        List<AdministratorDto> list = service.selectByCode(code);
            if(list!=null && list.size()==1){
                return ResultUtil.success(list.get(0));
            }else{
                return ResultUtil.error(SysErrorEnum.LOGIN_FAIL);
            }
    }

}
