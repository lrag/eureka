package com.curso.servicio;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.curso.servicio")
public class ErroresValidacionHandler {

	public ErroresValidacionHandler() {
		super();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errores = e
			.getBindingResult()
			.getFieldErrors()
			.stream()
			.collect(Collectors.toMap( fe -> (String) fe.getField(), 
					                   fe -> (String) fe.getDefaultMessage()));
		return new ResponseEntity<Object>(errores, HttpStatus.BAD_REQUEST);		
	}

}
