package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	// 요청 URL : http://localhost/lesson06/ex01/add_user_view
	@RequestMapping("/ex01/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	@ResponseBody
	@PostMapping("/ex01/add_user")
	public String addUser(
			@ModelAttribute NewUser newUser) {
		
		// DB insert
		newUserBO.addNewUser(newUser);
		
		//return "lesson06/afterAddUser";
		return "success";
	}
	
	@RequestMapping("/ex01/after_add_user")
	public String afterAddUser() {
		return "lesson06/afterAddUser";
	}
}
