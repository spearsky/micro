package com.test.springboot.study.service;

import com.test.springboot.study.domain.posts.Posts;
import com.test.springboot.study.domain.posts.PostsRepository;
import com.test.springboot.study.web.dto.PostsResponseDto;
import com.test.springboot.study.web.dto.PostsSaveRequestDto;
import com.test.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

/*
2-2 PostsService를 추가

    Dto > Controller > service > Repository

2-8
    해야하는 절차.
            update id O <------> save id x
            update 수행하기 전에 id를 가지고 원본데이터를 찾는 일이 수행해야 함.
 */

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // For Update
    // update posts set ..... where id='1';
    /*
    2-8 findById()는 아이디로 Repository를 찾아서 entity를 생성
    entity를 PostsResponseDto 객체를 반환

    save : http://localhost:8080/api/v1/posts
    update : (id)
            http://localhost:8080/api/v1/posts/34

    GetMapping, PostMapping
    Insert : PostMapping
    Update : PutMapping
    SElect * : GetMapping
     */
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("찾는 원본 게시글 없다. id =" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("찾는 원본 게시글 없다. id =" + id));
        return new PostsResponseDto(entity);
    }
}
