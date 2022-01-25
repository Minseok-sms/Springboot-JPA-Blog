package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
		
	private static final String TAG = "HttpController Test : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234")
				.email("hello").build();
		
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("spring");
		System.out.println(TAG + "setter : " + m.getUsername());
		return "lombok test success";
		
	}
	
	//인터넷 주소창요청은 get방식밖에안됨. (select)
	//http://localhost:8080/http/get
		@GetMapping("/http/get")
		public String getTest(Member m) {
			
			return "get 요청 : " + m.getId() +", "+ m.getUsername() + ", "+ m.getPassword() 
					+ ", " + m.getEmail();
		}
		@PostMapping("/http/post")// text/plain, application/json 
													//MessageConverter (스프링부트)
		public String postTest(@RequestBody Member m) {
			return "post 요청 : " + m.getId() +", "+ m.getUsername() + ", "+ m.getPassword() 
			+ ", " + m.getEmail();  
		}
		
		@PutMapping("/http/put")
		public String putTest(@RequestBody Member m) {
			return "put 요청" + m.getId() +", "+ m.getUsername() + ", "+ m.getPassword() 
			+ ", " + m.getEmail();
		}
		@DeleteMapping("/http/delete")
		public String deleteTest() {
			return "delete 요청";
		}
}
