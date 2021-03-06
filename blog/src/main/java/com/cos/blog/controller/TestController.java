package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.blog.model.Calculator;

@Controller
public class TestController {

//	@GetMapping("/test/result")
//	public String testResult(@RequestParam("number1") int num1, 
//			@RequestParam("number2") int num2, 
//			Model model) {
//		int sum_value = num1 + num2;
//		model.addAttribute("sum" , sum_value);
//		return "test/result";
//		
//	}
	@PostMapping("/test/result")
	public String testResult(@RequestBody Calculator cal,
			Model model) {
		int sum_value = cal.getNum1() + cal.getNum2();
		model.addAttribute("sum" , sum_value);
		return "test/result";
		
	}
	
	@GetMapping("/test")
	public String testJsp() {
	
		return "test/form1";
	}
}
