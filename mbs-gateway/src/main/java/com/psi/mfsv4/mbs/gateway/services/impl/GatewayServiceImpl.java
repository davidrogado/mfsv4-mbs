package com.psi.mfsv4.mbs.gateway.services.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.psi.mfsv4.mbs.common.http.HttpMethod;
import com.psi.mfsv4.mbs.common.http.HttpRequest;
import com.psi.mfsv4.mbs.common.http.HttpResponse;
import com.psi.mfsv4.mbs.common.interfaces.Workflow;
import com.psi.mfsv4.mbs.gateway.abstracts.AbstractGatewayService;
import com.psi.mfsv4.mbs.gateway.common.Constant;
import com.psi.mfsv4.mbs.gateway.common.EJBWorkflows;
import com.psi.mfsv4.mbs.gateway.entity.WorkflowEntity;
import com.psi.mfsv4.mbs.gateway.exceptions.AccessNotAllowedException;
import com.psi.mfsv4.mbs.gateway.exceptions.HttpRequestException;
import com.psi.mfsv4.mbs.gateway.exceptions.InvalidAuthenticationException;
import com.psi.mfsv4.mbs.gateway.exceptions.WorkflowNotFoundException;
import com.psi.mfsv4.mbs.gateway.repository.WorkflowRepository;
import com.psi.mfsv4.mbs.gateway.services.GatewayService;
import com.tlc.common.Logger;

@Service
public class GatewayServiceImpl extends AbstractGatewayService implements GatewayService {

	@Autowired
	private WorkflowRepository repository;
	
	@Override
	public ResponseEntity<String> execute(HttpMethod method, String raw, HttpServletRequest request) {
		try {
			HttpRequest req = this.parse(method, raw, request);
			String resource = req.getPathParams().toString();
			
			/***
			 * Check "Auth", if invalid throw InvalidAuthenticationException
			 * 
			 **/

			WorkflowEntity entity = repository.findByResource(resource, method.name());
			Workflow workflow = EJBWorkflows.lookup(method, entity.getUrl());
			if (workflow == null) {
				throw new WorkflowNotFoundException(String.format("%s ~ %s", method.name(), resource));
			}
			
			/***
			 * Check ACL, if not allowed throw AccessNotAllowedException
			 * select * from tblaccesscontrol where apiuser = client_apiuser and module = workflow.getId
			 **/
			
			HttpResponse httpres = workflow.execute(req);
			HttpHeaders hdr = new HttpHeaders();
			for (String key : httpres.getHeaders().keySet()) {
				hdr.add(key, httpres.getHeaders().get(key));
			}

			hdr.add(Constant.HDR_CONTENT_TYPE, "application/json");
			return ResponseEntity.status(httpres.getHttpStatus()).headers(hdr).body(httpres.getRaw());

		} catch (HttpRequestException e) {
			Logger.LogServer(e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		} catch (WorkflowNotFoundException e) {
			Logger.LogServer(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (InvalidAuthenticationException e) {
			Logger.LogServer(e);
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

		} catch (AccessNotAllowedException e) {
			Logger.LogServer(e);
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		} catch (Exception e) {
			Logger.LogServer(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
