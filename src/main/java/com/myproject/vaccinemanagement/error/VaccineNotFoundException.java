package com.myproject.vaccinemanagement.error;

public class VaccineNotFoundException extends RuntimeException{

	public VaccineNotFoundException(String message) {
		super(message);
	}

}
