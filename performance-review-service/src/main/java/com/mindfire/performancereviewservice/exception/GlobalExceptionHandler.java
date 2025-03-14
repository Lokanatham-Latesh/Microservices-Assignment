package com.mindfire.performancereviewservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(FeedbackException.class)
	    public ResponseEntity<ProblemDetails> handleFeedbackException(FeedbackException ex) {
	        ProblemDetails problemDetails = ProblemDetails.forBadRequest(ex.getMessage());
	        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ProblemDetails> handleGlobalException(Exception ex) {
	        ProblemDetails problemDetails = ProblemDetails.forInternalError(ex.getMessage());
	        return new ResponseEntity<>(problemDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();

	        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	    
	    
	    @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ProblemDetails> handleIllegalArgumentException(IllegalArgumentException ex) {
	        ProblemDetails problemDetails = ProblemDetails.forBadRequest(ex.getMessage());
	        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
	    }
}
