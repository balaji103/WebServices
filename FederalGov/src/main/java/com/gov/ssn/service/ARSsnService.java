package com.gov.ssn.service;

import com.gov.ssn.model.SsnModel;

public interface ARSsnService {
 
	public SsnModel saveUser(SsnModel um);
	
	public SsnModel getUserBySsnAndDob(Long ssn,String dob);

}
