package com.psi.mfsv4.mbs.common.interfaces;

import javax.ejb.Remote;

import com.psi.mfsv4.mbs.common.http.HttpRequest;
import com.psi.mfsv4.mbs.common.http.HttpResponse;

@Remote
public interface Workflow {
	HttpResponse execute(HttpRequest request);	
	int getId();
}
