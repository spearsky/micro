package com.test.springboot.study.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
    1-7 lombok 설치후에 getter, constructor 자동 생성 위해
    @Getter, @RequiredArgsContstructor 를 추가(즉, lombok 작동하는지 확인)

    @Getter
        필드의 get method 를 자동 생성
    @RequiredArgsConstructor
        선언된 final field가 포함된 생성자를 자동 생성

    단위테스트를 위해서 패키지 구조를 일치시키고, 클래스 이름은 현재클래스Test 로 만든다.
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int age;
}
