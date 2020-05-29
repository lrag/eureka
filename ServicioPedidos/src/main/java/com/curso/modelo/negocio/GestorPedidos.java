package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.persistencia.RepositorioClientes;
import com.curso.modelo.persistencia.RepositorioPedidos;

@Service
@Transactional(propagation=Propagation.REQUIRED) 
public class GestorPedidos {

	@Autowired private RepositorioClientes repoClientes;
	@Autowired private RepositorioPedidos repoPedidos;
	
	@Autowired private ClientesRestProxy clientesRest;
	
	public Pedido altaPedido(Pedido pedido) {

		String login = pedido.getCliente().getLogin();
		
		Cliente cliente = repoClientes
			.findById(login)
			.orElseGet( () -> {
				System.out.println("Invocando al microservicio de clientes");
				return clientesRest.buscar(login).getBody().asCliente();
			});
		
		pedido.setCliente(cliente);
		
		repoClientes.save(cliente);
		repoPedidos.save(pedido);
		
		return pedido;
	}

	public void modificar(Pedido pedido) {
		// TODO Auto-generated method stub		
	}

	public void borrar(Integer idPedido) {
		// TODO Auto-generated method stub		
	}
	
}










