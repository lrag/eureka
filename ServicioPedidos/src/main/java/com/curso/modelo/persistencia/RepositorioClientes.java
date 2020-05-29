package com.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curso.modelo.entidad.Cliente;

public interface RepositorioClientes extends JpaRepository<Cliente, String>{

}
