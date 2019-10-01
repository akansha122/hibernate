package com.zensar.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

//Hibernate Query Language(Object Oriented Query Language)
public class HqlMain {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure();

		// Singleton and heavy weight session factory object(f)
		SessionFactory f = c.buildSessionFactory();

		// Represent database connection and light weight
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		t.commit();
		// JPA Query
		// Query q = s.createQuery("From Product");
		// Query q = s.createQuery("From Product p where p.price>20000 and
		// p.price<70000");
		// Query q = s.createQuery("From Product p where p.price between 30000 and
		// 70000");
		// Query q = s.createQuery("From Product p where p.brand like'S%'");
		/*
		 * Query q = s.createQuery("From Product p where p.name='mobile'");
		 * List<Product> products = q.getResultList();
		 * 
		 * for (Product p : products) { System.out.println(p); }
		 */

		// New Code
		// Query q = s.createQuery("select p.name, p.price from Product p");
		// Query q = s.createQuery("select p.productId, p.name, p.brand from Product
		// p");
		/*
		 * Query q = s.createQuery("select p.price, p.brand, p.name from Product p");
		 * List<Object[]> objects = q.getResultList();
		 * 
		 * for (Object[] o : objects) { for (Object ob : o) { System.out.println(ob); }
		 * 
		 * }
		 */
		
		Query q= s.createQuery("select max(p.price) from Product p");
		Float maxPrice= (Float) q.getSingleResult();
		System.out.println(maxPrice);
		
		Query q1= s.createQuery("select min(p.price) from Product p");
		Float minPrice= (Float) q1.getSingleResult();
		System.out.println(minPrice);
		
		Query q2= s.createQuery("select sum(p.price) from Product p");
		Double sumPrice= (Double) q2.getSingleResult();
		System.out.println(sumPrice);
		
		Query q3= s.createQuery("select avg(p.price) from Product p");
		Double avgPrice= (Double) q3.getSingleResult();
		System.out.println(avgPrice);
		
		Query q4= s.createQuery("select count(p.price) from Product p");
		Long count= (Long) q4.getSingleResult();
		System.out.println(count);
		
		/*
		 * Criteria cr= s.createCriteria(Product.class); List<Product> products =
		 * cr.list(); for(Product p: products) { System.out.println(p); }
		 */
		
		
	}

}
