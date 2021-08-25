package com.test.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// auto import : alt + enter
// build.gradle 파일이 변경된 경우 무조건 sync를 해줘야 한다.
// @SpringBootApplication : SpringBoot의 시작부분을 알린다.
// run() : 내장 WAS (like tomcat)을 실행하라는 명령어.
// File > Settings > Editor > General > code Completion > Match case 해제 되었는지 확인

/*
2-11 이 어플래케이션이 JPA Auditing 어노테이션을 활성화하라고 명령해야함. > @EnableJpaAuditing

    저장소와 관련해서 생성, 수정하는 경우에 Auditing 이 동작함
    동작을 검증하기 위해서 저장소와 관련된 단위테스트
    PostsRepositoryTest 에 auditing 기능을 추가
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
