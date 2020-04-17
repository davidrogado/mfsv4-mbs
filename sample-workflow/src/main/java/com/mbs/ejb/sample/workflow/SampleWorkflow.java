package com.mbs.ejb.sample.workflow;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.psi.mfsv4.mbs.common.http.HttpRequest;
import com.psi.mfsv4.mbs.common.http.HttpResponse;
import com.psi.mfsv4.mbs.common.interfaces.Workflow;

@Stateless
@Remote(Workflow.class)
public class SampleWorkflow implements Workflow {

	@Override
	public HttpResponse execute(HttpRequest request) {
		System.out.println("method: " + request.getType().name());
		System.out.println("path: " + request.getPathParams().toString());
		System.out.println("query: " + request.getQueryParams().toString());
		System.out.println("body:" + request.getRaw());
		return new HttpResponse(200);
	}

	@Override
	public int getId() {
		return 0;
	}

}
