package com.ncscode.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ncscode.course.services.exceptions.DatabaseExcepiton;
import com.ncscode.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
	}
	
	@ExceptionHandler(DatabaseExcepiton.class)
	public ResponseEntity<StandarError> database(DatabaseExcepiton e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError(Instant.now(), httpStatus.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
	}

}
