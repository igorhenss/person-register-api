package com.igorhenss.personregisterapi.infrastructure.exception;

public class VerificationException extends RuntimeException {
	
	private final Object[] args;
	
	public VerificationException(String message, Object... args) {
		super(message);
		this.args = args;
	}
	
	public Object[] getArgs() {
		return args;
	}
	
}
