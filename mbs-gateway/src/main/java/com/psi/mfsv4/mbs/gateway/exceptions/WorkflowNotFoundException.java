package com.psi.mfsv4.mbs.gateway.exceptions;

public class WorkflowNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WorkflowNotFoundException() {
		super();
	}
	
	public WorkflowNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public WorkflowNotFoundException(String message) {
		super(message);
	}
	
	public WorkflowNotFoundException(Throwable cause) {
		super(cause);
	}

}
