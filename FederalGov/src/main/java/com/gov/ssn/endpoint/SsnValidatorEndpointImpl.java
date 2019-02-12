package com.gov.ssn.endpoint;

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
		System.out.println("in endpoint method");
		IndvDetailResponse indvDetailRessponse = new IndvDetailResponse();
		IndvDetailType detailType = null;
		//invoke service layer method
		SsnModel model = service.getUserBySsnAndDob(indvDetailRequest.getSsn(), indvDetailRequest.getDob());
		//validate ssn no is available or not
		if(model!=null) {
			detailType = new IndvDetailType();
			detailType.setFirstName(model.getFirstName());
			detailType.setLastName(model.getLastName());
			detailType.setDob(model.getDob());
			detailType.setSsn(model.getSsn());		
		}
		//set type to response
		indvDetailRessponse.setIndvDetail(detailType);
		//return response to consumer
		return indvDetailRessponse;
	}

}
