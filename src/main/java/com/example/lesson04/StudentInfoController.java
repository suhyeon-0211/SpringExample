package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentInfoBO;
import com.example.lesson04.model.StudentInfo;

@RequestMapping("/lesson04")
@Controller
public class StudentInfoController {

	@Autowired
	private StudentInfoBO studentInfoBO;
	
	// 요청 URL : http://localhost/lesson04/ex02/1
	@RequestMapping("/ex02/1")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 요청 URL : http://localhost/lesson04/ex02/add_student
	@PostMapping("/ex02/add_student")
	public String addStudent(
			@ModelAttribute StudentInfo studentInfo, // name 태그 값과 일치하는 필드에 값이 들어간다.
			Model model) {
		// 학생정보 파라미터 받기
		
		// DB INSERT
		studentInfoBO.addStudentInfo(studentInfo);
		
		// DB SELECT
		StudentInfo lastAddedStudent = studentInfoBO.getStudentInfoById(studentInfo.getId());
		
		// VIEW 데이터 세팅
		model.addAttribute("student", lastAddedStudent);
		
		return "lesson04/afterAddStudent";
	}
}
