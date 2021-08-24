package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 메소드에 붙은 mapping보다 먼저 적용
@Controller
public class Ex01Controller {
	
	// String 출력하기
	// 요청 URL : http://localhost/lesson01/ex01/1
	@ResponseBody 			   // 리턴되는 값을 HTML Response Body로 보낸다.
	@RequestMapping("/1") // 주소 매핑
	public String printString() {
		String text = "예제  1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap() {
		// {"키"=값}
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 1);
		map.put("peach", 7);
		map.put("grape", 14);
		
		// MessageConverter
		// map을 리턴하면 json으로 나타난다. web starter에 jackson이라는 라이브러리가 포함되어 있기 때문
		// @ResponseBody 어노테이션이 있기 때문에 jackson이 동작함
		return map;
	}
}
