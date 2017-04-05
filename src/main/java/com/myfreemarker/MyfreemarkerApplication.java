package com.myfreemarker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myfreemarker.dao")
//@MapperScan("org.spring.springboot.dao")
public class MyfreemarkerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyfreemarkerApplication.class, args);
	}
}
