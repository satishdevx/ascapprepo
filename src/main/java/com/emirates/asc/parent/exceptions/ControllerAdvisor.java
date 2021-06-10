package com.emirates.asc.parent.exceptions;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ControllerAdvisor.class);

	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<Object> handleCityNotFoundException(CityNotFoundException ex, WebRequest request) {
		LOG.info(":::: ControllerAdvisor ::: handleCityNotFoundException ::::");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "City not found");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ASCException.class)
	public ResponseEntity<Object> handleNodataFoundException(ASCException ex, WebRequest request) {
		LOG.info(":::: ControllerAdvisor ::: handleNodataFoundException ::::");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "No cities found");
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOG.info(":::: ControllerAdvisor ::: handleMethodArgumentNotValid ::::");
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("errors", errors);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError() {
		LOG.info(":::: ControllerAdvisor ::: databaseError ::::");
		// Nothing to do. Returns the logical view name of an error page, passed
		// to the view-resolver(s) in usual way.
		// Note that the exception is NOT available to this view (it is not added
		// to the model) but see "Extending ExceptionHandlerExceptionResolver"
		// below.
		return "databaseError";
	}
}