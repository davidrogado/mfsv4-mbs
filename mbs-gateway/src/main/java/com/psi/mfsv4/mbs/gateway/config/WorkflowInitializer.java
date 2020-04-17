package com.psi.mfsv4.mbs.gateway.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psi.mfsv4.mbs.gateway.common.EJBWorkflows;
import com.psi.mfsv4.mbs.gateway.repository.WorkflowRepository;

@Component
public class WorkflowInitializer {
	
	@Autowired
	private WorkflowRepository repository; 
	
	@PostConstruct
	public void init() {
		EJBWorkflows.init(repository.findAll());
	}

}
