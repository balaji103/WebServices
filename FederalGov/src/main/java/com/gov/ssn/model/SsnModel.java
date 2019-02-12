package com.gov.ssn.model;

import lombok.Data;
/**
 * this is for used model data in model class
 * @author balaji
 *
 */
@Data
public class SsnModel {

	private Long ssn;

	private String firstName;

	private String lastName;

	private String gender;
	
	private String phno;
	
    private String dob;

}
