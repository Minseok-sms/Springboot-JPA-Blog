package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//@RestController은 return이 문자 그자체를 반환
	//@Controller가붙으면 함수는 파일을반환. 해당경로에있는 파일을 리턴.
	//기본경로 : src/main/resources/static
	// return : /home.html
	
	
	@GetMapping("/temp/home")
	public String tempHome() {
		return "/home.html";
	}
	
	// application.yml에서 요청하면
	// prefix : /WEB-INF/views/
	// suffix : .jsp 를  @Controller가 붙으면 자동으로 붙여줌
	// return : test
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "test";
	}
 
}
