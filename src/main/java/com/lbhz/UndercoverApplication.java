package com.lbhz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-02-29 13:55
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lbhz.core.dao"})
@ComponentScan(basePackages = {"com.lbhz.*"})
@EnableSwagger2
public class UndercoverApplication {
    public static void main(String[] args) {
        SpringApplication.run(UndercoverApplication.class, args);
    }
}
