package com.test.springboot.study.web;

import javafx.beans.binding.StringExpression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
1-6 Hellocontroller 의 테스트 모듈을 만들때는 뒤에 Test라는 이름을 갖는다.
    반드시 위쪽(main)과 패키지 구조가 같아야 한다.

    @ExtendWith : Juint4 에서 @RunWith의 Junit5 버전
        Springboot 테스트와 JUnit 연결기능 수행(즉, 테스트시 꼭 필요)

    @Autowired : 자동 주입, 스프링이 관리하는 Bean 을 자동 주입

    private MockMvc
        웹 API 테스트시 사용
        스프링 mvc 테스트의 시작점
        HTTP, HET, POST에 대한 API 테스트 시 사용

    STATUS - OK : 200

    메소드 체이닝(Method Chaining) : mvc.perform().andExpect()
                                   mvc.perform().andExpect(content) 을 단순황
                                   >>
                                   mvc.perform().andExpect(status).andExplect(content);

    단위테스트는 동작이 정상적인지만 확인
    실제 서비스를 돌리려면 Application 을 실행 후 http://localhost:8080/hello 화면에 hello 글씨가 뜨면 일단 성공
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void helloReturnTest() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));


    }
}
