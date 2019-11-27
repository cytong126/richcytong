package com.wang.boot.pt.parttimes.main.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 *@author: Wang He
 *@time: 2019/11/5 0005 10:01
 *@description:
 */
@Component
@ConfigurationProperties(prefix = "myproper")
public class MySetProperties {

    //@Value("${crosAllowedMethod}")
    private String crosAllowedMethod;

   // @Value("${crosMapping}")
    private String crosMapping;
   //@Value("${crosAllowedOrigins}")
    private String[] crosAllowed0rigins;

    public String getCrosAllowedMethod() {
        return crosAllowedMethod;
    }

    public void setCrosAllowedMethod(String crosAllowedMethod) {
        this.crosAllowedMethod = crosAllowedMethod;
    }

    public String getCrosMapping() {
        return crosMapping;
    }

    public void setCrosMapping(String crosMapping) {
        this.crosMapping = crosMapping;
    }

    public String[] getCrosAllowed0rigins() {
        return crosAllowed0rigins;
    }

    public void setCrosAllowed0rigins(String[] crosAllowed0rigins) {
        this.crosAllowed0rigins = crosAllowed0rigins;
    }
}
