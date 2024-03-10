package com.example.library00;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.library00.book.dao.mapper")
public class Library00Application {

    public static void main(String[] args) {
        SpringApplication.run(Library00Application.class, args);
    }

}
