package com.cos.blog.test;

import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//사용자가 요청 -> 응답(HTML 파일) => @Controller

// 사용자가 요청 -> 응답(data)

@RestController
public class HttpControllerTest {
	
	
	private static final String TAG = "HttpControllerTest : ";
	
	//localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {

		Member m = Member.builder().password("1234").username("ssar").email("ssar.nate@naf").build();
		System.out.println(TAG + "getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : " + m.getId());
		
		return "lombok 테스트 완료!!!!";
	}
	
	//인터넷 브라우저 요청은 반드시 get 요청만 가능!!
	// 나머지는 postman으로 확인
	
	// http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		
		return "get 요청 : " + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //MessageConverter가 자동 매핑
		return "post 요청 : " + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + " , " + m.getUsername() + " , " + m.getPassword() + " , " + m.getEmail();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
