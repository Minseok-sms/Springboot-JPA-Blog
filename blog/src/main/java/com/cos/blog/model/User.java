package com.cos.blog.model;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



// ORM -> 자바(모든 다른언어)의 오브젝트를 테이블로 맵핑해줌.
@Entity //User 클래스가 MySQL 에 테이블이 생성됨.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더 패턴
@DynamicInsert
public class User {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에연결된 db의 넘버링 전략을 따라감
	private int id; // 시퀀스. auto_increment;
	
	@Column(name = "username", nullable = false, length = 100, unique = true) // null값이 될수없다.
	private String username; // 아이디	
	
	@Column(nullable = false, length = 100) 
	private String password; 
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	
	//@ColumnDefault("'user'")
	//private String role; // Enum을 쓰는게 좋다.// admin, user, manager
									// domain설정이가능하다 -> 어떤 데이터가 될수있는 범위가 정해졌다.(enum)
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	private String oauth; // kakao, google
	
	@CreationTimestamp // 시간이 자동으로 입력이된다
	private Timestamp createDate; //회원이 가입한시간?
	
}
