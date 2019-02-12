package com.gov.ssn.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.gov.ssn.bindings.IndvDetailRequest;
import com.gov.ssn.bindings.IndvDetailResponse;

@Endpoint
public interface SsnValidatorEndpoint {

	public IndvDetailResponse ssnValidate(IndvDetailRequest indvDetailRequest);
}
