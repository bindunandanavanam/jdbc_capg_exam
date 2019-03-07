package com.cg.mra.userexception;

public class UserException extends Exception{

		public UserException(){
			System.err.println("Given Account ID doesn't exists");
		}

	}

