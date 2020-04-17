package com.psi.mfsv4.mbs.gateway.exceptions;

public class InvalidAuthenticationException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAuthenticationException() {
		super();
	}
	
	public InvalidAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidAuthenticationException(String message) {
		super(message);
	}
	
	public InvalidAuthenticationException(Throwable cause) {
		super(cause);
	}

}
