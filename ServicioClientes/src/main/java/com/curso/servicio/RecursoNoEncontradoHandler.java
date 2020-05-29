package com.curso.servicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.servicio.excepcion.RecursoNoEncontradorException;

@ControllerAdvice(basePackages = "com.curso.servicio")
public class RecursoNoEncontradoHandler {

	public RecursoNoEncontradoHandler() {
		super();
	}

	@ExceptionHandler(RecursoNoEncontradorException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(RecursoNoEncontradorException e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);		
	}

}
