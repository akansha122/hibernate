package com.zensar.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*@author Akansha shah
@creation_date 26/09/2019 2:54PM 
@modification_date 26/09/2019 2:54PM
@copyright Zensar technologies. All rights reserved.
@version 2.0
@description: 
*/
@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int countryId;
	private String countryName;
	private String language;
	private long population;
	@OneToOne
	@JoinColumn(name = "flag")
	private Flag flag;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

}
