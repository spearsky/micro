package com.test.springboot.study.web;

import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
