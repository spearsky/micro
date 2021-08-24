package com.test.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// auto import : alt + enter
// build.gradle 파일이 변경된 경우 무조건 sync를 해줘야 한다.
// @SpringBootApplication : SpringBoot의 시작부분을 알린다.
// run() : 내장 WAS (like tomcat)을 실행하라는 명령어.
// File > Settings > Editor > General > code Completion > Match case 해제 되었는지 확인
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
