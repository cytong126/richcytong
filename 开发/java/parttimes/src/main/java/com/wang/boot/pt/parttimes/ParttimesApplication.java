package com.wang.boot.pt.parttimes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.wang.boot.pt.parttimes.*.mapper")
public class ParttimesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParttimesApplication.class, args);
    }

}
