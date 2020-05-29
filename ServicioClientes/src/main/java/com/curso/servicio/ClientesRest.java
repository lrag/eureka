package com.curso.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.RepositorioClientes;
import com.curso.servicio.dto.ClienteDto;
import com.curso.servicio.excepcion.RecursoNoEncontradorException;

@RestController
@RequestMapping("clientes")
public class ClientesRest {

	@Autowired private GestorClientes gestorClientes;
	@Autowired private RepositorioClientes repoClientes;
	
	@GetMapping(path="/{login}",
				produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDto> buscar(@PathVariable("login") String login) throws RecursoNoEncontradorException {
		return repoClientes
			.findById(login)
			.flatMap( c -> Optional.of(new ResponseEntity<ClienteDto>(new ClienteDto(c), HttpStatus.OK)))
			.orElseThrow( () -> new RecursoNoEncontradorException("Cliente no encontrado"));
	}

	@GetMapping(produces=MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<ClienteDto> listar() {
		return repoClientes
			.findAll()
			.stream()
			.map( p -> new ClienteDto(p))
			.collect(Collectors.toList());
	}

	@PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, 
			     produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDto> insertar(@Valid() @RequestBody() ClienteDto clienteDto, 
			                                   BindingResult br) {
		Cliente cliente = clienteDto.asCliente();
		gestorClientes.altaCliente(cliente);
		return new ResponseEntity<>(new ClienteDto(cliente), HttpStatus.OK);
	}

	@PutMapping(path = "/{login}", 
			    consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, 
		        produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDto> modificar(@PathVariable("login") String login,
			                                    @Valid() @RequestBody() ClienteDto clienteDto, 
			                                    BindingResult br) {
		Cliente cliente = clienteDto.asCliente();
		cliente.setLogin(login);
		gestorClientes.modificarCliente(cliente);
		return new ResponseEntity<>(new ClienteDto(cliente), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{login}")
	public ResponseEntity<String> borrar(@PathVariable("login") String login) {
		gestorClientes.bajaCliente(new Cliente(login));
		return new ResponseEntity<>("Cliente borrado", HttpStatus.OK);
	}

}
