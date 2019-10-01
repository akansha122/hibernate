package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperation {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure();

		// Singleton and heavy weight session factory object(f)
		SessionFactory f = c.buildSessionFactory();

		// Represent database connection and light weight
		Session s = f.openSession();
		Transaction t = s.beginTransaction();

		// Insert new record
		// Product product = new Product(1006, "Bottle", "ModWare", 85467);
		// s.save(product);

		/*
		 * // get record according to primary key Product product = s.get(Product.class,
		 * 1002);
		 * 
		 * if (product != null) { System.out.println(product); } else {
		 * System.out.println("product not found"); }
		 */
		// System.out.println(product);

		/*
		 * Product product= s.load(Product.class, 1002); System.out.println(product);
		 */

		/*
		 * Product product = s.get(Product.class, 1002);
		 * 
		 * if (product != null) { s.update(product);
		 * 
		 * } else { System.out.println("product not found"); }
		 */

		// delete record
		/*
		 * Product p = s.get(Product.class, 1002);
		 * 
		 * if (p != null) { s.delete(p); } else System.out.println("");
		 */

		t.commit();
		s.close();

	}

}
