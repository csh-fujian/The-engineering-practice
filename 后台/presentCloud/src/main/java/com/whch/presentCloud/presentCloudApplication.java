package com.whch.presentCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.whch.presentCloud.mapper")
public class presentCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(presentCloudApplication.class, args);
    }

}
