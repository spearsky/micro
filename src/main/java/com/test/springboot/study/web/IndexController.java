package com.test.springboot.study.web;

import com.test.springboot.study.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
3-1 IndexController

    http://localhost:8080/index

    @Controller 를 붙이면 해당 클래스를 웹 요청 처리하는 컨트롤러로 사용하겠다.

    TODO
    Controller > ControllerTest 단위테스트를 만든다.
    디렉토리 구조가 같아야한다.

3-3 /posts/save 링크(get)를 만났을 때 처리할 매핑 정보를 추가해준다

3-4 글쓰기 action 등을 세팅하지 않고 JS로 처리를 해보겠다.
    JS, stylesheet 등을 폴더 포함시키기 위해서는 디렉토리를 만들어야 한다.
    JS : resources/static/js/app/index.js
    stylesheet : resources/static/css/style.css

3-6 Index 로 데이터를 전달해줘야한다.
    이를 위해서 index() 함수를 수정해 줘야 한다.
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
