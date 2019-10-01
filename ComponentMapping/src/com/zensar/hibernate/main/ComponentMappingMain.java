package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) {

		Configuration c = new Configuration().configure();
		SessionFactory s = c.buildSessionFactory();
		Session session = s.openSession();
		Transaction t = session.beginTransaction();
		Name name = new Name();
		name.setFirstName("Akansha");
		//name.setMiddleName("R");
		name.setLastName("Shah");

		Customer customer = new Customer(104, name, "female", 20, "pune");
		customer.setBirthDate(LocalDate.of(2019, 05, 26));
		try {
			File photo = new File("./resources/images.jfif");
			FileInputStream fin = new FileInputStream(photo);
			Blob customerPhoto = BlobProxy.generateProxy(fin, photo.length());
			customer.setProfilePhoto(customerPhoto);
			File file2= new File("./resources/customerinfo.txt");
			FileReader reader = new FileReader(file2);
			Clob description = ClobProxy.generateProxy(reader, file2.length());
			customer.setDescription(description);
			session.save(customer);
			t.commit();
			session.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
