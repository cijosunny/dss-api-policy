package com.cks.dss.api.policy;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DssApiPolicyBaseConfig {
	@Value("${pcc.rolledoutstates}")
	private List<String> pccRolledOutStates;

	public List<String> getPccRolledOutStates() {
		return pccRolledOutStates;
	}

	public void setPccRolledOutStates(List<String> pccRolledOutStates) {
		this.pccRolledOutStates = pccRolledOutStates;
	}
}
