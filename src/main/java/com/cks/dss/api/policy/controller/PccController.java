package com.cks.dss.api.policy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cks.dss.api.policy.DssApiPolicyBaseConfig;

@RestController
public class PccController {
	private Logger logger = LoggerFactory.getLogger(PccController.class);
	
	@Autowired
	private DssApiPolicyBaseConfig dssApiPolicyBaseConfig;
	
	@GetMapping("/pccavailable/{state}")
	public String isPccDataAvailable(@RequestParam(value = "state", required = false) String stateInQuery,
			@PathVariable(name = "state",required = false) String stateInPath){
		logger.info("Check PCC Availability For State In Query : {}, State In Path : {}", stateInQuery, stateInPath);
		logger.info("PCC Rolled Ou States : {}",dssApiPolicyBaseConfig.getPccRolledOutStates());
		if(dssApiPolicyBaseConfig.getPccRolledOutStates().contains(stateInQuery)
				|| dssApiPolicyBaseConfig.getPccRolledOutStates().contains(stateInPath)) {
			return "Yes";
		}
		return "No";
	}
}
