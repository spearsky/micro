package com.test.springboot.study.web;

import com.test.springboot.study.config.auth.dto.SessionUser;
import com.test.springboot.study.service.PostsService;
import com.test.springboot.study.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

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

3-8 postsUpdate() 기능 추가

3-15 google login  기능 추가
    로그인을 추가하기 위해서는 Session 처리해주어야 한다.

    세션에 user 정보가 있으면(로그인 되었다는 의미) 사용자 정보중 userName 으로 값을 index로 보낸다.
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
            //model.addAttribute("email", user.getEmail());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-update";
    }
}
