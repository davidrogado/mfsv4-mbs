package com.psi.mfsv4.mbs.gateway.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.psi.mfsv4.mbs.common.http.HttpMethod;

public interface GatewayService {
	
	public ResponseEntity<String> execute(HttpMethod method, String raw, HttpServletRequest request);

}
