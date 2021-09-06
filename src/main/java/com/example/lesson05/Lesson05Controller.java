package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	// 요청 URL : http://localhost/lesson05/ex01
	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("바나나");
		fruits.add("사과");
		fruits.add("귤");
		fruits.add("오렌지");
		fruits.add("레몬");
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "박수현");
		user.put("age", 23);
		user.put("hobby", "독서");
		users.add(user);
		
		user = new HashMap<>();
		user.put("name", "신바다");
		user.put("age", 25);
		user.put("hobby", "게임");
		users.add(user);
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
}
