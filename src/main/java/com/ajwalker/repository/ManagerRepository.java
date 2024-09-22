package com.ajwalker.repository;

import com.ajwalker.entity.Manager;
import com.ajwalker.utility.enums.EState;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ajwalker.utility.HibernateConnection.em;

public class ManagerRepository extends RepositoryManager<Manager,Long> {
	private static ManagerRepository instance;
	private ManagerRepository() {
		super(Manager.class);
	}
	public static ManagerRepository getInstance() {
		if (instance == null) {
			instance = new ManagerRepository();
		}
		return instance;
	}
	//SELECT * FROM tblmanager WHERE username = '?username' AND PASSWORD = '?password'
    public Optional<Manager> findByUsernameAndPassword(String username, String password) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
			Root<Manager> root = cq.from(Manager.class);
			cq.select(root);
			cq.where(cb.and(cb.equal(root.get("username"), username),cb.equal(root.get("password"), password)));
			return Optional.ofNullable(em.createQuery(cq).getSingleResult());
		}
		catch (NoResultException e){
			return Optional.empty();
		}
		catch (RuntimeException e) {
			System.err.println("findByUsernameAndPassword metodunda hata..." + e.getMessage());
		}
		return Optional.empty();
	}
}