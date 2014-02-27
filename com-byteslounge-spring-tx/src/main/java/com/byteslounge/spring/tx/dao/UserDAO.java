package com.byteslounge.spring.tx.dao;

import java.util.List;

import com.byteslounge.spring.tx.model.TestJpaTableEntity;

public interface UserDAO {

	void insertUser(TestJpaTableEntity user);

	List<TestJpaTableEntity> findAllUsers();
}
