package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.config.auth.PrincipalDetail;
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
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired // HttpSession 객체는 ioc컨테이너에 등록되어있음.
//	private HttpSession session;
	

	
	@PostMapping("/auth/joinProc") // 회원가입 controller
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("save 함수 호출됨.");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.회원수정(user);
		// 비밀번호여기서 변경되면 db에서는 바꼇지만 현재 세션에서의 정보는 안바껴잇음 
		// 다시로그아웃햇다가 다시들어가야함. 우리가직접 세션값을 변경해줘야함.
		

		//세션등록
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		Authentication authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		securityContext.setAuthentication(authentication);
//		session.setAttribute("SPRING_SECURITY_CONTEXT", authentication);
		
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
