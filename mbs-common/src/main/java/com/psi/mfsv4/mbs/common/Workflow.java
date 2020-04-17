package com.psi.mfsv4.mbs.common;

import com.psi.mfsv4.mbs.common.http.HttpRequest;
import com.psi.mfsv4.mbs.common.http.HttpResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Workflow {
	
	protected HttpRequest request;
	public abstract HttpResponse execute();	
	public abstract int getId();

}
