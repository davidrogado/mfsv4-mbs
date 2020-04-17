package com.psi.mfsv4.mbs.common.annotations;

import java.lang.annotation.Inherited;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.psi.mfsv4.mbs.common.interfaces.Workflow;

@Inherited
@Stateless
@Remote
public @interface RemoteWorkflow {
	
	Class<?>[] value() default {Workflow.class};
	
}

