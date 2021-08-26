package com.test.springboot.study.config.auth.dto;

import com.test.springboot.study.domain.user.User;
import lombok.Getter;
import java.io.Serializable;


/*
3-14 Session 관련 기능 추가
Session은 로그인 기능을 서버가 관리는 기술 <----> Cookie
점점 Session기능이 강화되는 것이 웹의 추세
이 파일까지 등록했을 때, 모든 에러가 사라져야 정상
IndexController에 가서 세션처리하면 구글 로그인이 완성
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}