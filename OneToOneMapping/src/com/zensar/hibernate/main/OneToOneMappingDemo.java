package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Country country = new Country();
		country.setCountryName("India");
		country.setLanguage("Hindi");
		country.setPopulation(13000000L);

		Flag flag = new Flag();
		flag.setFlagName("Tiranga");
		flag.setDescription("It is a three color flag");
		flag.setCountry(country);
		country.setFlag(flag);

		session.save(country);
		session.save(flag);
		transaction.commit();
		session.close();
	}
}
