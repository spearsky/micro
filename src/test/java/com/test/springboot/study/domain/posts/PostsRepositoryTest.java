package com.test.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

/*
1-12
    @AfterEach
        각 단위 테스트가 끝날때 마다 수행하는 작업 정의 <--> @BeforeEach
        JUnit4 @After 에 해당하는 녀석
        다음 테스트가 다른 데이터를 침범하는 것을 방지

    posts : Insert / Update 구분하는 방법
        Insert : id가 없으면 글 등록
        Update : id가 있으면 글 수정으로 판단

1-13
    디비 쿼리가 제대로 수행되는지 확인 할 방법이 없다.
    이를 해결하는 방법은, property 설정으로 가능한데
    src/main/resources/application.properties 파일에 속석을 설정한다.


    cf. CURL
        curl http://www.daum.net

 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad() {
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save(
                Posts
                .builder()
                    .title(title)
                    .content(content)
                    .author("spearsky@spearsky.com")
                .build());

        // insert > List
        /*
            C
            D
            E  <-- A를 추가

            A(0)
            C
            D
            E

         */
        List<Posts> postsList = postsRepository.findAll();
        // select * 수행 후 목록 결과를 List Collection에 넣는 작업을 한다.

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    /*
    2-12 Auditing

    단위테스트 확인후 성공했으면,
    Application을 실행한 후
    http://localhost:8080/h2-console 에 접속해서
    Ports 테이블에 CreateDate, ModifiedDate 필드가 추가된 것을 확인

    2-13 Mustache 화면 구성
        매우 간단한 템플릿 엔진
        화면구성을 위한 틀을 만들어놓고, 데이터가 추가되어야하는 부분만 프로그램으로 채우는 방식
        장점 : 문법이 매우 단순하다.
              View 역할만 수행
              InteliJ 에서는 plugins 로 간단하게 설치가능
              Ctrl + Shift + A : plugins 검색 > mustache 설치

              Mustache 를 사용하기 위해서는 bundle.gradle 에 추가해준다 >> sync

              src > resource > templates > index.mustache
     */
    @Test
    public void BaseTimeEntityRegister(){
        LocalDateTime now = LocalDateTime.of(2021,8,25,16,10,22);
        postsRepository.save(Posts
                .builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
