package com.zensar.entities;

import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*@author Akansha shah
@creation_date 26/09/2019 2:53PM 
@modification_date 26/09/2019 2:53PM
@copyright Zensar technologies. All rights reserved.
@version 1.0
@description: It is persistance class.
*/

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "cId")
	private int customerId;
	private Name customerName;
	private String gender;
	private int age;
	private String address;
	private LocalDate birthDate;
	private Blob profilePhoto;
	private Clob description;

	public Clob getDescription() {
		return description;
	}

	public void setDescription(Clob description) {
		this.description = description;
	}

	public Blob getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(Blob profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, Name customerName, String gender, int age, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender + ", age="
				+ age + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
