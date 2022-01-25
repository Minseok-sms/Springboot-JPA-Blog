package com.cos.blog.test;


import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired //의존성주입
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 존재하지 않음.";
		}
		return "삭제완료됨. id : " + id; 
	}
	
	
	//email, password
	//GetMapping이랑 주소겹쳐도 알아서구분해줌.
	@Transactional
	@PutMapping("/dummy/user/{id}")  // Json 데이터를요청 -> Java Object (MessageConverter의 잭슨 라이브러리가 변환해서받아줌)
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {

		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});
			
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
//		
		//save를 호출안했는데 @Transactional 붙임으로서 업데이트가됨
		//더티채킹?
		
		
		//userRepository.save(user);
		return user;
	}
	
	
	//유저전체목록찾기
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//한페이지당 2건의 데이터를 리턴
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		return userRepository.findAll(pageable).getContent();
	}
	
	//회원가입
	// http의 body에 username, password, email데이터를 가지고 요청
	@PostMapping("/dummy/join")
	public String join(User user) {
		userRepository.save(user);
		return "회원가입이 완료되었습니다";
	}
	
	//유저찾기
	//http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//  user/4를 찾으면 db에서 찾을수가 없으니 user가 null이되니 
		//  return null이 리턴이된다. Optional로 User객체를 감싸서 null인지 아닌지 판단해서 return
		
//     1
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
			}
		});
		
//     2
//		User user = userRepository.findById(id).get();
		
		
		// 스프링부트는 MessageConverter가 응답시 자동 작동. 
		// 자바오브젝트를 리턴하게되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 Json 타입의 형태로 변환함.
		return user;
	}
	
	
	
}
