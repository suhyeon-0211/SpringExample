package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;
import com.example.lesson04.model.NewUser;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public void addNewUser(NewUser newUser) {
		newUserDAO.insertNewUser(newUser);
	}
	
	public NewUser getLastNewUser() {
		return newUserDAO.selectLastNewUser();
	}
	
	public boolean existNewUserByName(String name) {
		return newUserDAO.existNewUserByName(name);
	}
}
