package com.test.springboot.study.web;

import com.test.springboot.study.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
    http://localhost:8080/hello

    MEthod
        GET, POST, PUT, DELETE, OPTIONS
        
    @RestController
        JSON(name : hong)으로 변환하는 컨트롤러
        Spring에서의 @ResponseBody에 해당
        
    @GetMapping / @PostMapping / @PutMapping / @DeleteMapping
       select        insert         update         delete
       
   HTTP Error Code(Status Code) 확인방법
   Google 검색 : RFC HTTP로 검색한 결과의 첫번째 페이지에서 error code 검색 및 확인 가능
 */

/*
1-7 롬복(Lombok)
        Getter, Setter, Default Constructor, toString 등을 Annotation으로 자동 생성해주는 방법
        롬복 설치 (Ctrl + Shift + A)
            plugins > Lombok 설치
            File > Settings > Build, Excuting, DeployMent > Compiler > Annotation Processors 선택
            화면의 오른쪽에 Enable annotation processing 을 체크 해준다.
            롬복 사용을 위해 gradle 에 추가
 */

/*
1-8 dto를 getter로 추가하는 방법
    http://localhost:8080/hello/dto?name=홍길동&age=99
*/

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("age") int age) {
        return new HelloResponseDto(name, age);
    }
}
