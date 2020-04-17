package com.psi.mfsv4.mbs.gateway.common;

import java.util.Hashtable;
import java.util.List;

import javax.naming.InitialContext;

import com.psi.mfsv4.mbs.common.http.HttpMethod;
import com.psi.mfsv4.mbs.common.interfaces.Workflow;
import com.psi.mfsv4.mbs.gateway.entity.WorkflowEntity;
import com.tlc.common.Logger;

public class EJBWorkflows {

	private static Hashtable<String, String> put = new Hashtable<String, String>();
	private static Hashtable<String, String> get = new Hashtable<String, String>();
	private static Hashtable<String, String> post = new Hashtable<String, String>();
	private static Hashtable<String, String> delete = new Hashtable<String, String>();

	public static void init(List<WorkflowEntity> entities) {
		Logger.LogServer("Initializing EJB Workflows ...");
		for (WorkflowEntity entity : entities) {
			String method = entity.getMethod();
			String resource = entity.getUrl();
			String ejbName = entity.getWorkflow();

			if (method.equals("POST"))
				post.put(resource, ejbName);
			if (method.equals("GET"))
				get.put(resource, ejbName);
			if (method.equals("PUT"))
				put.put(resource, ejbName);
			if (method.equals("DELETE"))
				delete.put(resource, ejbName);
			
			Logger.LogServer(String.format("%s ~ %s ~ %s", method, resource, ejbName));

		}
	}

	public static Workflow lookup(HttpMethod method, String resource) {
		try {
			String ejbName = null;
			switch (method) {
			case PUT:
				ejbName = put.get(resource);
				break;
			case GET:
				ejbName = get.get(resource);
				break;
			case POST:
				ejbName = post.get(resource);
				break;
			case DELETE:
				ejbName = delete.get(resource);
				break;
			}

			if (ejbName != null) {
				Object context = InitialContext.doLookup(ejbName);
				return (Workflow) context;
			}

		} catch (Exception e) {
			Logger.LogServer(e);
			
		}
		return null;
	}

}
