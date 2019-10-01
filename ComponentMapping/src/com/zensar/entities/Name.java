package com.zensar.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.sun.istack.Nullable;

/*@author Akansha shah
@creation_date 26/09/2019 2:44PM 
@modification_date 26/09/2019 2:44PM
@copyright Zensar technologies. All rights reserved.
@version 1.0
@description: It is bean class.
*/

@Embeddable
public class Name {
	@Column(name = "first", length = 30)
	private String firstName;
	private String middleName;
	private String lastName;

	public Name() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
	}

	public Name(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

}
