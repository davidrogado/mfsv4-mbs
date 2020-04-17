package com.psi.mfsv4.mbs.gateway.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psi.mfsv4.mbs.common.http.HttpMethod;
import com.psi.mfsv4.mbs.gateway.services.GatewayService;

@RestController
@RequestMapping("/mbs/svc")
public class GatewayController {

	@Autowired
	private GatewayService service;
	
	@GetMapping("/**")
	public ResponseEntity<String> get(HttpServletRequest req) {
		return service.execute(HttpMethod.GET, null, req);
	}
	
	@PostMapping("/**")
	public ResponseEntity<String> post(@RequestBody(required = false) String raw, HttpServletRequest req) {
		return service.execute(HttpMethod.POST, raw, req);
	}
	
	@PutMapping("/**")
	public ResponseEntity<String> put(@RequestBody(required = false) String raw, HttpServletRequest req) {
		return service.execute(HttpMethod.PUT, raw, req);
	}
	
	@DeleteMapping("/**")
	public ResponseEntity<String> delete(@RequestBody(required = false) String raw, HttpServletRequest req) {
		return service.execute(HttpMethod.DELETE, raw, req);
	}

}
