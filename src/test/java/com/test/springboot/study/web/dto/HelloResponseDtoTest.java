package com.test.springboot.study.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
108 Lombok Test 모듈
    실행하면 final field 때문에 문제가 생기는 것이 정상
    build.gradle에서 작업해준다.
    다음 3라인을 추가한다.
        annotationProcessor('org.projectlombok:lombok')
        testImplementation('org.projectlombok:lombok')
        testAnnotationProcessor('org.projectlombok:lombok')
    sync 후 다시 단위테스트를 하면 정상적인 것 까지 확인(즉, lombok 에서 자동으로 initialrization 을 만든다)
 */

public class HelloResponseDtoTest {

    @Test
    public void lobkokTest() {
        String name = "test";
        int age = 34;

        HelloResponseDto dto = new HelloResponseDto(name, age);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAge()).isEqualTo(age);
    }
}
