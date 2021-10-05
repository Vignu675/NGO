package com.capgemini.exception;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capgemini.payload.ValidationErrorResponse;

@RestControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler{

	private final String BAD_REQUEST = "BAD_REQUEST";

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchEmployeeException.class)
	public String handleNoSuchEmployeeException(NoSuchEmployeeException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchDonorException.class)
	public String handleNoSuchDonorException(NoSuchDonorException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicateEmployeeException.class)
	public String handleDuplicateEmployeeException(DuplicateEmployeeException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DuplicateDonorException.class)
	public String handleDuplicateDonorException(DuplicateDonorException e) {
		return e.getMessage();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ValidationErrorResponse> handleConstraintViolation(ConstraintViolationException ex,
			WebRequest request) {
		List<String> details = ex.getConstraintViolations().parallelStream().map(e -> e.getMessage())
				.collect(Collectors.toList());

		ValidationErrorResponse validationErrResp = new ValidationErrorResponse();
		validationErrResp.setTimestamp(LocalDateTime.now());
		validationErrResp.setMessage(BAD_REQUEST);
		validationErrResp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		validationErrResp.setDetails(details);

		return new ResponseEntity<>(validationErrResp, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

//Get all errors
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
}
