package com.byteslounge.spring.tx.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.byteslounge.spring.tx.dao.UserDAO;
import com.byteslounge.spring.tx.model.TestJpaTableEntity;


@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insertUser(TestJpaTableEntity user) {
		// entityManager.persist(user);

		Query createQuery = entityManager
				.createQuery("update TestJpaTableEntity set NAME=:changedName where PHONE=:keynumberValue");
		createQuery.setParameter("changedName", "name updated 9");
		createQuery.setParameter("keynumberValue", "0997897");
		createQuery.executeUpdate();
	}

	public List<TestJpaTableEntity> findAllUsers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TestJpaTableEntity> cq = builder
				.createQuery(TestJpaTableEntity.class);
		Root<TestJpaTableEntity> root = cq.from(TestJpaTableEntity.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

}
