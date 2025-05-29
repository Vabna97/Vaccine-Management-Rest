package com.myproject.vaccinemanagement.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myproject.vaccinemanagement.error.VaccineNotFoundException;

@RestControllerAdvice
public class VaccineControllerAdvice {

	@ExceptionHandler(VaccineNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleVaccineNotFoundException(VaccineNotFoundException vnf){
		ErrorDetails error= new ErrorDetails(vnf.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(VaccineNotFoundException e){
		ErrorDetails error= new ErrorDetails(e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
