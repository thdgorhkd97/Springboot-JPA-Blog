package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("temphome");
		
		//파일 리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	//jsp는 정적파일이 아니라서 static 밑에서 인식 X
	@GetMapping("/temp/jsp")
	public String tempJsp() {
//		prefix: /WEB-INF/views/
//	    suffix: .jsp
//		풀네임 : /WEB-INF/views//test.jsp.jsp  (return "/temp.jps")일때
		
		return "test";
	}
}
