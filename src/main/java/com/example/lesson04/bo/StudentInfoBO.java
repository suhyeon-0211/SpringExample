package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.StudentInfoDAO;
import com.example.lesson04.model.StudentInfo;

@Service
public class StudentInfoBO {

	@Autowired
	private StudentInfoDAO studentInfoDAO;
	
	public void addStudentInfo(StudentInfo studentInfo) {
		studentInfoDAO.insertStudentInfo(studentInfo);
	}
	
	public StudentInfo getStudentInfoById(int id) {
		return studentInfoDAO.selectStudentInfoById(id);
	}
}
