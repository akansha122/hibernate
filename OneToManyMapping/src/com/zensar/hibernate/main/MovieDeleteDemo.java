package com.zensar.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Movie;
import com.zensar.entities.Song;

public class MovieDeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Movie movie = session.get(Movie.class, 1);
		System.out.println(movie.getTitle());
		System.out.println(movie.getReleaseDate());
		List<Song> songs = movie.getSongs();

		for (Song s : songs) {
			System.out.println(s);
		}

		if (movie != null)
			session.delete(movie);
		else
			System.out.println("Sorry! movie not found");
		
		transaction.commit();
		
		movie.getMovieId();
		session.save(movie);
		
		session.close();
	}

}
