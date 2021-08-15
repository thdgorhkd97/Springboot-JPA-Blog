package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//컴포넌트 스캔을 위해 반드시 처음 패키지 이름을 가지고 새로운 패키지 생성
//ex -> com.cos.blog.test (O)
//ex -> com.cos.test(X) => 컴포넌트 스캔하지 않아서 IoC 불가능ㅡㅡ

//스프링이 com.cos.blog 패키지 이하의 모든 파일을 new하는 것이 아니라
// 특정 어노테이션이 있는 클래스만 new해서(IoC) 스프링 컨테이너에 관리
@RestController
public class BlogControllerTest {

	//http://localhost:8080/test/hello
	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello spring boot by Song</h1>";
	}
}
