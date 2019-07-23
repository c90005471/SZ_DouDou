package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动程序
 * 
 * @author aaaTeacher 20190411
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.aaa.project.*.*.mapper")
//@EnableCaching
public class DouDouApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DouDouApplication.class, args);
    }
}