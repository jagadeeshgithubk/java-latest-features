package com.byteslounge.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.spring.tx.model.TestJpaTableEntity;
import com.byteslounge.spring.tx.user.UserManager;

public class Main {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

//		List<TestJpaTableEntity> list = userManager.findAllUsers();
//		System.out.println("User count: " + list.size());

		TestJpaTableEntity user = new TestJpaTableEntity();
		user.setADDRESS("address 4");
		user.setNAME("test");
		user.setPHONE("123456789");
		userManager.insertUser(user);
		System.out.println("User inserted!");
		System.out.println("User inserted!");
//		list = userManager.findAllUsers();
//		System.out.println("User count: " + list.size());

	}
}
