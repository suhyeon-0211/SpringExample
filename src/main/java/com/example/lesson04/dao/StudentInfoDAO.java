package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson04.model.StudentInfo;

@Repository
public interface StudentInfoDAO {
	public void insertStudentInfo(StudentInfo studentInfo);
	public StudentInfo selectStudentInfoById(int id);
}
