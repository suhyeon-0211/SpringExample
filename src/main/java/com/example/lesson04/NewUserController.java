package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {

	@Autowired
	private NewUserBO newUserBO;
	
	// 요청 URL : http://localhost/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1")
	public String ex01_1() {
		return "lesson04/addUser";
	}
	
	// 요청 URL : http://localhost/lesson04/ex01/add_user
	//@RequestMapping(path = "/ex01/add_user", method = RequestMethod.POST)
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		// DB insert
		NewUser newUser = new NewUser();
		newUser.setName(name);
		newUser.setYyyymmdd(yyyymmdd);
		newUser.setEmail(email);
		newUser.setIntroduce(introduce);
		newUserBO.addNewUser(newUser);
		return "lesson04/afterAddUser";
	}
	
	// 요청 URL : http://localhost/lesson04/ex01/last_user
	@GetMapping("/ex01/last_user")
	public String lastUser(Model model) {
		// 마지막에 가입된 사람 하나의 정보를 가지고 온다. select DB
		NewUser user = newUserBO.getLastNewUser();
		model.addAttribute("user", user);
		model.addAttribute("title", "회원 정보");
		return "lesson04/lastUser"; // 결과 jsp
	}
}
