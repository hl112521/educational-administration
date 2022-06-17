package com.zijin.educationaladministration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Autor: 丁小丁
 * @Desc: 教务系统-SpringBoot引导类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zijin.educationaladministration.dao"}) //扫描继承了TKMapper Mapper<T>接口的Bean
public class EducationalAdministrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationalAdministrationApplication.class, args);
    }

}
