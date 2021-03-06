package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;


//해당 repository는 유저테이블을 관리하는거고 유저테이블의 pk는 integer다
//DAO
//자동으로 bean으로 등록이된다.
//@Repository 생략가능
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
		// Select * from user where username = 1?;
		Optional<User> findByUsername(String username);
	
	
	
	
	
	
		//JPA Naming전략
		//SELECT * FROM user WHERE username = ?1 AND password = ?2;
//		User findByUsernameAndPassword(String username, String password);
		
//		@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2",
//					nativeQuery = true)
//		User login(String username, String password);
}
