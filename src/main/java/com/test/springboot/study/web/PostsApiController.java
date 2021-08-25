package com.test.springboot.study.web;

import com.test.springboot.study.service.PostsService;
import com.test.springboot.study.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
2-1 PostsApiController
    http://localhost:8080/api/v1/posts
    
    controller가 Service한테 save()를 요청하는 구조
    이때 주고받는 데이터 단위가 RequestDto 형태
    PostMapping(Insert), GetMapping, DeleteMapping, PutMapping(Update)
    
    Dto > Controller 저장요청 > Service 저장 수행

    com.test.springboot.study.service 패키지 만들고
    그안에 PostsService 객체를 만들 예정(현재 이코드는 서비스(PostsService)가 없어서 에러)
 */

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
