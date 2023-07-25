package com.bookstoreapp.exception;

import com.bookstoreapp.dto.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

@RestControllerAdvice
public class BookstoreErrorHandler {

    // create a method to handle BookNotFoundException
	 @ResponseStatus(code = HttpStatus.NOT_FOUND)

	  @ExceptionHandler(BookNotFoundException.class)

	  public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex,

	      HttpServletRequest request) {

	    HttpStatus status = HttpStatus.NOT_FOUND;

	    ErrorResponse response = new ErrorResponse(status.value(), ex.getMessage(),

	        System.currentTimeMillis(), "/books", status.getReasonPhrase());

	    return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);

	  }

    // create a method to handle BookAlreadyExistsException
   @ResponseStatus(code = HttpStatus.CONFLICT)

   @ExceptionHandler(BookAlreadyExistsException.class)

   public ResponseEntity<ErrorResponse> handleBookAlreadyExistsException(BookAlreadyExistsException ex,

       HttpServletRequest request) {

     HttpStatus status = HttpStatus.CONFLICT;

     ErrorResponse response = new ErrorResponse(status.value(), ex.getMessage(),

         System.currentTimeMillis(), "/books", status.getReasonPhrase());

     return new ResponseEntity<ErrorResponse>(response, status);

   }

    // create a method to validate the request body
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
      ErrorResponse response = new ErrorResponse(status.value(), "Validation failed",
          System.currentTimeMillis(), "/books", status.getReasonPhrase());
      return new ResponseEntity<ErrorResponse>(response, status);
    }

  
    // create a method to handle Exception
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherException(Exception ex, HttpServletRequest request) {
      HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
      ErrorResponse response = new ErrorResponse(status.value(), "Internal server error",
          System.currentTimeMillis(), "/books", status.getReasonPhrase());
      return new ResponseEntity<ErrorResponse>(response, status);
    }
}
