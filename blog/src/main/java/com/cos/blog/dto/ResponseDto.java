package com.cos.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;


//롬북
@Data  //getter setter
@NoArgsConstructor // default 생성자 
@AllArgsConstructor // 생성자
@Builder
public class ResponseDto<T> {
	int status;
	T data;
}
