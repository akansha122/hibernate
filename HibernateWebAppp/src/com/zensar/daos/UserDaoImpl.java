package com.zensar.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

/**
 * @author Akansha Shah
 * @version 2.0
 * @creation_date 21st sep 2019 5.35PM
 * @modification_date 28st sep 2019 11.11AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description:It is Data Access Object Interface implementor class. It is used
 *                 in Persistance layer of application.
 */
public class UserDaoImpl implements UserDao {

	private Session session;

	public UserDaoImpl() {

		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		session = factory.openSession();
	}

	@Override
	public void insert(User user) {
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
	}

	@Override
	public void update(User user) {
		Transaction transaction1 = session.beginTransaction();
		session.update(user);
		transaction1.commit();
	}

	@Override
	public void delete(User user) {
		Transaction transaction2 = session.beginTransaction();
		session.delete(user);
		transaction2.commit();
	}

	@Override
	public User getByUserName(String username) {
		return session.get(User.class, "radha");
	}

	@Override
	public List<User> getAll() {
		Query query = session.createQuery("from User");
		return query.getResultList();
	}

}
