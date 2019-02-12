package com.gov.ssn.dao;

import java.io.Serializable;

/***
 * this is class user for db operation
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gov.ssn.entity.SsnEntity;
@Repository("adUserMasterDao")
public interface ARSsnRegisterDao extends JpaRepository<SsnEntity, Serializable> {

	@Query(name="from SsnEntity se where se.ssn=:ssn and se.dob=:dob")
	public SsnEntity findUserBySsnAndDob(Long ssn,String dob);
}
