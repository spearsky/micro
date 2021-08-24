package com.test.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// auto import : alt + enter
// build.gradle 파일이 변경된 경우 무조건 sync를 해줘야 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
