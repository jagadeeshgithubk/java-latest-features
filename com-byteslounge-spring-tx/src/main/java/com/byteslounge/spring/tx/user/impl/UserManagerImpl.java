package com.byteslounge.spring.tx.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.TestJpaTableEntity;
import com.byteslounge.spring.tx.user.UserManager;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDAO;

	
//	@Transactional
	public void insertUser(TestJpaTableEntity user) {
		userDAO.insertUser(user);
	}

	public List<TestJpaTableEntity> findAllUsers() {
		return userDAO.findAllUsers();
	}

}
