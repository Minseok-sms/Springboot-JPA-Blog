package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


//인증이 안된 사용자들이 출입할 수 있는 경로 /auth/,  / 기본주소
@Controller
public class UserController {
	
	@Autowired //의존성주입
	private UserRepository userRepository;
	
	
	@GetMapping({"" ,  "/"})
	public String index() {
		return "index";
	}

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm"; // 	/WEB-INF/views/user/joinForm.jsp
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm"; // 	/WEB-INF/views/user/joinForm.jsp
	}
	
	@PostMapping("/auth/user/login")
	public String join(@RequestBody User user) {
		userRepository.save(user);
		return "index";
	}
	
	
	
	
	
	
	
	
}