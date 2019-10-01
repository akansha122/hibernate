package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*@author Akansha shah
@creation_date 27/09/2019 4:41PM 
@modification_date 27/09/2019 4:41PM
@copyright Zensar technologies. All rights reserved.
@version 2.0
*/
@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	@ManyToOne
	@JoinColumn(name = "movid_id")
	private Movie movie;

	public Song(int songId, String songName, Movie movie) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.movie = movie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Song() {
		// TODO Auto-generated constructor stub
	}


	public Song(String songName) {
		super();
		this.songName = songName;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + "]";
	}

}
