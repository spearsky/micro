package com.test.springboot.study.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/*
3-1 index.mustache 의 body 부분의 텍스트를 가져오는지 확인하는 절차
    단위테스트 확인
    Application을 실행

    http://localhost:8080 했을 때 화면에 bootstrap test 라는 글씨가 나오면 정상
    mustache오 ㅏ연동확인, index파일에 접근 되는 것 확인
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadMappingPage(){
        String body = this.restTemplate.getForObject("/",String.class);
        assertThat(body).contains("bootstrap");
    }
}
