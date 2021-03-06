package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // 스프링이 com.cos.blog 패키지 이하를 스캔해 특정 어노테이션 클래스파일을 new해서
					// IOC스프링 컨테이너에 관리해준다.
@RestController
public class BlogControllerTest {
	
	// http://localhost:8080/test/hello 로들어갈시 함수반환.
	@GetMapping("/test/hello")
	public String hello() {
		return "hello spring boot";
	}
}
