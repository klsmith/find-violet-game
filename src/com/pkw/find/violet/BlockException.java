package com.pkw.find.violet;

public class BlockException extends Exception {
	private static final long serialVersionUID = -2335048092789925925L;

	String message;

	public BlockException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
