package com.zensar.hibernate.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class OneToManyMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Movie movie = new Movie();
		movie.setTitle("DDLJ");
		movie.setReleaseDate(LocalDate.of(2019, 5, 20));

		Song song = new Song();
		song.setSongName("Teri meri kahani");
		song.setMovie(movie);

		Song song1 = new Song("Kabir Singh");
		song1.setMovie(movie);
		
		Song song2 = new Song("Dream Girl");
        song2.setMovie(movie);
        
		List<Song> list = new ArrayList();
		list.add(song);
		list.add(song1);
		list.add(song2);

		movie.setSongs(list);
		session.save(movie);
		session.save(song);
		session.save(song1);
		session.save(song2);
		transaction.commit();
		session.close();

	}

}
