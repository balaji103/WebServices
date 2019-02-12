package com.gov.ssn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
/**
 * this is used for mapping in AR_USER_MASTER
 * @author gopal
 *
 */
@Entity
@Table(name = "AR_FEDERAL_MASTER")
@Data
public class SsnEntity {
	@Id 
	@SequenceGenerator(name="SSN_NO_SEQ",initialValue=99999999, allocationSize=1)  
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SSN_NO_SEQ")
	@Column(name = "SSN_NO")
	private Long ssn;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
 
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "PHONE_NO")
	private String phno;

	@Column(name = "DOB")
	private String dob;


}
