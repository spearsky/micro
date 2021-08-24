package com.test.springboot.study.web.dto;

import com.test.springboot.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
1-15
    DTO > Controller > Service 형태로 프로그램의 구조를 잡는 순서 1
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntry(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
