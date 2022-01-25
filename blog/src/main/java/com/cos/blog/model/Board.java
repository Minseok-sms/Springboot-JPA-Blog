package com.cos.blog.model;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//ORM 클래스이다.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더 패턴
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량데이터
	private String content;// 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨.
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = board, User = One // 여러보드를 하나의 유저가생성.
	@JoinColumn(name="userId ")
	private User user;// DB는 오브젝트를 저장할수 없다. 자바는 오브젝트저장가능
								   // db가 테이블이 어떻게인식하냐 ?
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy는 연관관계의 주인이아니다. (FK가아님)
	private List<Reply> reply; 
	
	@CreationTimestamp
	private Timestamp createDate;
}
