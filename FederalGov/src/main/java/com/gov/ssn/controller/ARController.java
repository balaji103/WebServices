package com.gov.ssn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.ssn.model.SsnModel;
import com.gov.ssn.service.ARSsnService;
import com.gov.util.AppConstants;

/**
 * this class is controller class
 * 
 * @author gopal
 *
 */
@Controller
public class ARController {

	@Autowired
	private ARSsnService arService;

	/**
	 * this is used for home page and login page(admin / case worker)
	 * 
	 * @param us
	 * @param model
	 * @return string
	 */
	@RequestMapping({ "/", "/index" })
	public String getSsnRegistrationForm(Model model) {
		model.addAttribute("ssnModel", new SsnModel());
		return "ssnRegistration";
	}

	/**
	 * this method is used for generate ssn number form
	 * 
	 * @param us
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/ssnRegistration", method = RequestMethod.POST)
	public String regPage(@ModelAttribute("ssnModel") SsnModel ssnModel, Model model) {
		// invoke service layer method
		ssnModel = arService.saveUser(ssnModel);

		// add to msg to model
		if (ssnModel.getSsn()!= null) {
			model.addAttribute(AppConstants.SUCCESS, "SSN Generate successfully...your SSN NO is : " + ssnModel.getSsn());
		} else {
			model.addAttribute(AppConstants.ERROR, AppConstants.SSN_REG_ERROR);
		}
		// return lvn
		return "ssnRegistration";
	}

}