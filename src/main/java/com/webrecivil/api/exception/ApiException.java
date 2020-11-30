package com.webrecivil.api.exception;

@SuppressWarnings("serial")
public class ApiException extends Exception {

	public ApiException(String msg) {
		super(msg);
	}

	public ApiException(Exception ex) {
		super(ex);
	}

	public ApiException(String msg, Exception ex) {
		super(msg, ex);
	}

}
