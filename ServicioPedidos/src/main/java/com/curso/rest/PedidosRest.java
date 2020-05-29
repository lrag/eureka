package com.curso.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.negocio.GestorPedidos;
import com.curso.modelo.persistencia.RepositorioPedidos;
import com.curso.rest.dto.PedidoDto;
import com.curso.servicio.excepcion.RecursoNoEncontradorException;

//@Controller
@RestController
@RequestMapping("/pedidos")
public class PedidosRest {

	@Autowired private RepositorioPedidos repoPedidos;
	@Autowired private GestorPedidos gestorPedidos;
	
	@PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDto> insertar(@Valid() @RequestBody() PedidoDto pedidoDto) {
		Pedido pedido = pedidoDto.asPedido();
		gestorPedidos.altaPedido(pedido);
		return new ResponseEntity<>(new PedidoDto(pedido), HttpStatus.OK);		
	}

	@GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<PedidoDto> listar() {
		return repoPedidos
			.findAll()
			.stream()
			.map( p -> new PedidoDto(p))
			.collect(Collectors.toList());
	}
	
	@GetMapping(path="/{id}",
				produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<PedidoDto> buscar(@PathVariable("id") Integer id) throws RecursoNoEncontradorException {
		return repoPedidos
			.findById(id)
			.flatMap( p -> Optional.of(new ResponseEntity<PedidoDto>(new PedidoDto(p), HttpStatus.OK)))
			.orElseThrow( () -> new RecursoNoEncontradorException("Pedido no encontrado"));		
	}

	@PutMapping(path = "/{id}",
			    consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			    produces = MimeTypeUtils.APPLICATION_JSON_VALUE)	
	public ResponseEntity<PedidoDto> modificar(@PathVariable("id") Integer idPedido,
									           @Valid() @RequestBody() PedidoDto pedidoDto) {
		
		Pedido pedido = pedidoDto.asPedido();
		//Nos fiamos solo del id que viene en la url, no en el pedido del body
		pedido.setId(idPedido);
		gestorPedidos.modificar(pedido);
		return new ResponseEntity<>(new PedidoDto(pedido), HttpStatus.OK);		
	}	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable("id") Integer idPedido){
		gestorPedidos.borrar(idPedido);
		return new ResponseEntity<>("Pedido borrado", HttpStatus.OK);
	}
	
}
