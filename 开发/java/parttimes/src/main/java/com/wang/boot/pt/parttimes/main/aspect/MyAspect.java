package com.wang.boot.pt.parttimes.main.aspect;


import com.wang.boot.pt.parttimes.main.bean.CookieConstants;
import com.wang.boot.pt.parttimes.main.bean.MyConstants;
import com.wang.boot.pt.parttimes.main.bean.RedisConstants;
import com.wang.boot.pt.parttimes.main.exception.AdminLoginException;
import com.wang.boot.pt.parttimes.main.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录权限检验切面
 * Created by Administrator on 2017/11/6 0006.
 */
@Aspect
@Slf4j
@Component
public class MyAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

   // @Pointcut("execution(public * com.wang.boot.pt.parttimes.partcategory.controller.*(..))")
    @Pointcut("execution(public * com.wang.boot.pt.parttimes.*.controller.*.*(..))"+
            " && !execution(public * com.wang.boot.pt.parttimes.administrator.controller.AdministratorLoginController.*(..))")
    public void verify(){
        System.out.println("进入verify");
    }

    @Before("verify()")
    public void doVerify() {
        System.out.println("进入doVerify");
        //1.获取request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();


        //2.获取cookies
        Cookie cookie = CookieUtil.get(request , CookieConstants.TOKEN);
        if(null == cookie) {
            log.warn("【登录校验】cookie没有找到token");
            throw new AdminLoginException();
        }

        //3.获取redis

        String openid = stringRedisTemplate.opsForValue().get(String.format(RedisConstants.PREFIX , cookie.getValue()));
        if(StringUtils.isEmpty(openid)) {
            log.warn("【登录校验】redis没有找到token");
            throw new AdminLoginException();
        }

        //4.判断是哪个系统调用数据
        String header = request.getHeader("Origin");
        //如果是后台管理系统，则去sys_administrator表中查询是否存在此管理员
        if(header.equals( MyConstants.ADMIN_ADDR )){

        }
        //如果是客户端访问，则去用户表中查询是否存在此管理员
        if(header.equals( MyConstants.CLIENT_ADDR )){

        }


    }

}
