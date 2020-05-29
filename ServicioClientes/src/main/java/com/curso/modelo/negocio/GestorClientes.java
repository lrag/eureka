package com.curso.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.RepositorioClientes;

@Service
public class GestorClientes {

	@Autowired
	private RepositorioClientes repoClientes;
	
	public Cliente altaCliente(Cliente cliente){
		//Lógica de negocio para el alta...
		return repoClientes.save(cliente);
	}
	
	public Cliente modificarCliente(Cliente cliente){
		//Lógica de negocio para modificar...
		return repoClientes.save(cliente);
	}

	public void bajaCliente(Cliente cliente){
		//Lógica de negocio para la baja...
		repoClientes.delete(cliente);
	}
	
}
