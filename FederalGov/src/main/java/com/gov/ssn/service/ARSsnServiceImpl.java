package com.gov.ssn.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gov.ssn.dao.ARSsnRegisterDao;
import com.gov.ssn.entity.SsnEntity;
import com.gov.ssn.model.SsnModel;
/***
 * this class is used to business operation in the case worker
 * @author Nitish
 *
 */
@Service("arService")
public class ARSsnServiceImpl implements ARSsnService {
	@Autowired
	private ARSsnRegisterDao arSsnRegisterDao;

	@Override
	public SsnModel saveUser(SsnModel model) {
			SsnEntity entity = new SsnEntity();
            // copying data from model to entity
			BeanUtils.copyProperties(model, entity);
			//invoke dao layer method
            SsnEntity savedEntity = arSsnRegisterDao.save(entity);
			// setting generated pk value to model
            model.setSsn(savedEntity.getSsn());	

			return model;
		}

	@Override
	public SsnModel getUserBySsnAndDob(Long ssn, String dob) {
		//invoke dao layer method
        SsnEntity entity = arSsnRegisterDao.findUserBySsnAndDob(ssn, dob);
        //copy entity to model object
        SsnModel model = new SsnModel();
        BeanUtils.copyProperties(entity, model);
        //return model
		return model;
	}



}
	
		
	





