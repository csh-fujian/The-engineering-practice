package com.whch.presentCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan("com.whch.presentCloud.mapper")
public class NewspickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewspickerApplication.class, args);
    }

}
