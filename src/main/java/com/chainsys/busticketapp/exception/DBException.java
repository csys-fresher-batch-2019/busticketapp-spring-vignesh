package com.chainsys.busticketapp.exception;

@SuppressWarnings("serial")
public class DBException extends Exception {

	public DBException(String msg) {
		super(msg);
	}

	public DBException(String msg, Throwable t) {
		super(msg,t);
	}

}
