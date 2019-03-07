package com.cg.mra.userexception;

public class InvalidMobileNoException extends Exception {
	public InvalidMobileNoException() {
		// TODO Auto-generated constructor stub
		System.err.println("Number is not 10 digit");
	}
}
