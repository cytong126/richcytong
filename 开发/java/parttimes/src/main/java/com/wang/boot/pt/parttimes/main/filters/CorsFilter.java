package com.wang.boot.pt.parttimes.main.filters;

/*
 *@author: Wang He
 *@time: 2019/10/30 0030 17:15
 *@description:
 */


import com.wang.boot.pt.parttimes.main.bean.MySetProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "CorsFilter")
@Configuration
public class CorsFilter implements Filter {


    @Autowired
    private MySetProperties proper;

    @Override
    //@CrossOrigin(origins = "http://localhost:8084")
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        System.out.println("进入doFilter");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String  originHeader = httpServletRequest.getHeader("Origin");
        String[] allowedOrigins = proper.getCrosAllowed0rigins();
        if (Arrays.asList(allowedOrigins).contains(originHeader)) {
            System.out.println("11112222");
            response.setHeader("Access-Control-Allow-Origin",originHeader);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", proper.getCrosAllowedMethod());
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            chain.doFilter(req, res);
        }

    }

}
