package com.gov.ssn.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.gov.ssn.bindings.IndvDetailRequest;
import com.gov.ssn.bindings.IndvDetailResponse;
import com.gov.ssn.bindings.IndvDetailType;
import com.gov.ssn.model.SsnModel;
import com.gov.ssn.service.ARSsnService;

@Endpoint
public class SsnValidatorEndpointImpl{
	
	private static final Logger log = LoggerFactory.getLogger(SsnValidatorEndpointImpl.class);

	@Autowired
	private ARSsnService service;
	
	private static final String NAMESPACE_URI = "http://www.usa.gov/ssn/types";

	/**
	 * This method is used find Indv Details based on given ssn and dob
	 * WSDL URL : http://localhost:9090/service/federalSsnDetails.wsdl
	 * @param request
	 * @return IndvDetailResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "IndvDetailRequest")
	@ResponsePayload
	public IndvDetailResponse ssnValidate(@RequestPayload IndvDetailRequest indvDetailRequest) {
		log.info("in endpoint method");
		IndvDetailResponse indvDetailRessponse = null;
		IndvDetailType detailType = null;
		log.info("invoke service class method");
		//invoke service layer method
		SsnModel model = service.getUserBySsnAndDob(indvDetailRequest.getSsn(), indvDetailRequest.getDob());
		//validate ssn no is available or not
		if(model!=null) {
			log.info("in if(model!=null) "+model.toString());
			//create response object
			indvDetailRessponse = new IndvDetailResponse();
			detailType = new IndvDetailType();
			//set values to detailType obj
			detailType.setFirstName(model.getFirstName());
			detailType.setLastName(model.getLastName());
			detailType.setDob(model.getDob());
			detailType.setSsn(model.getSsn());	
			log.info("out if(model!=null) "+detailType.toString());
			
			//set type to response
			indvDetailRessponse.setIndvDetail(detailType);
			
			log.info("out endpoint method "+indvDetailRessponse.getIndvDetail() );
			//return response to consumer
			return indvDetailRessponse;
		}else {
			return indvDetailRessponse;
		}
	}

}
