package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritanceMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		employee.setName("Ankita");
		employee.setJoinDate(LocalDate.of(2019, 9, 26));
		employee.setSalary(45789.23);
        session.save(employee);
        
        WageEmp wemp=new WageEmp();
        wemp.setName("Neha");
        wemp.setJoinDate(LocalDate.of(2019, 02, 23));
        wemp.setSalary(7546.23);
        wemp.setHours(06);
        wemp.setRate(500.2f);
        
        session.save(wemp);
		transaction.commit();
		session.close();
	}

}
