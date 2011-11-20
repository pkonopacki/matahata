package com.zwort.matahata.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@NamedQueries({
//	@NamedQuery(name = "findAllBeneficiaries", query = "select b from Beneficiary b"),
//	@NamedQuery(name = "findActiveBeneficiaries", query = "select b from Beneficiary b where b.active = 1")
//})

@Entity
@Table(name = "beneficiary")
public class Beneficiary extends AbstractDictionaryEntity {

	private static final long serialVersionUID = -1729773504509452188L;
	
	@Column(name = "initials")
	private String initials;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private Date dateOfBirth;

	
	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
