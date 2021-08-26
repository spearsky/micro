package com.test.springboot.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
3-1 IndexController

    http://localhost:8080/index

    @Controller 를 붙이면 해당 클래스를 웹 요청 처리하는 컨트롤러로 사용하겠다.

    TODO
    Controller > ControllerTest 단위테스트를 만든다.
    디렉토리 구조가 같아야한다.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}