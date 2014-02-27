package com.byteslounge.spring.tx.user;

import java.util.List;

import com.byteslounge.spring.tx.model.TestJpaTableEntity;

public interface UserManager {

	void insertUser(TestJpaTableEntity user);

	List<TestJpaTableEntity> findAllUsers();
}
