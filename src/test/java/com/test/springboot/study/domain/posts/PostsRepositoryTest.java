package com.test.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

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
}
