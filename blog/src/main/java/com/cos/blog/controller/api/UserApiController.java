package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

//	@Autowired //의존성주입
//	private UserRepository userRepository;
	// 이걸대신 Service를 만들어서 사용

	@Autowired //DI
	private UserService userService;
	
//	@Autowired // HttpSession 객체는 ioc컨테이너에 등록되어있음.
//	private HttpSession session;
	

	
	@PostMapping("/auth/joinProc") // 회원가입 controller
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("save 함수 호출됨.");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("save 함수 호출됨.");
//		User principal = userService.로그인(user);// principal(접근주체)
//		
//		if(principal != null) { // 세션생성
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
}