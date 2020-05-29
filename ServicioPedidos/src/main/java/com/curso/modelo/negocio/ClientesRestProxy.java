package com.curso.modelo.negocio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.rest.dto.ClienteDto;

@FeignClient(name="ServicioClientes")
@RequestMapping("clientes")
public interface ClientesRestProxy {

	@GetMapping(path="/{login}",
			    produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDto> buscar(@PathVariable("login") String login);
	
}
