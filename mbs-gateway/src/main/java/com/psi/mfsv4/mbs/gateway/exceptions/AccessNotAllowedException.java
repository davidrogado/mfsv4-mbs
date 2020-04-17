package com.psi.mfsv4.mbs.gateway.exceptions;

public class AccessNotAllowedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessNotAllowedException() {
		super();
	}
	
	public AccessNotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AccessNotAllowedException(String message) {
		super(message);
	}
	
	public AccessNotAllowedException(Throwable cause) {
		super(cause);
	}

}
