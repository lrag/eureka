package com.curso.servicio.dto;

import javax.validation.constraints.NotEmpty;

import com.curso.modelo.entidad.Cliente;

public class ClienteDto {

	@NotEmpty
	private String login;
	private String preferencias;
	@NotEmpty
	private String nombre;
	private String direccion;
	@NotEmpty
	private String direccionEnvio;
	private String direccionFacturacion;
	@NotEmpty
	private String telefono;

	public ClienteDto() {
		super();
	}
	
	public ClienteDto(String login, String preferencias, String nombre, String direccion,
			String direccionEnvio, String direccionFacturacion, String telefono) {
		super();
		this.login = login;
		this.preferencias = preferencias;
		this.nombre = nombre;
		this.direccion = direccion;
		this.direccionEnvio = direccionEnvio;
		this.direccionFacturacion = direccionFacturacion;
		this.telefono = telefono;
	}

	public ClienteDto(Cliente cliente) {
		super();
		login = cliente.getLogin();
		preferencias = cliente.getPreferencias();
		nombre = cliente.getNombre();
		direccion = cliente.getDireccion();
		direccionEnvio = cliente.getDireccionEnvio();
		direccionFacturacion = cliente.getDireccionFacturacion();
		telefono = cliente.getTelefono();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public String getDireccionFacturacion() {
		return direccionFacturacion;
	}

	public void setDireccionFacturacion(String direccionFacturacion) {
		this.direccionFacturacion = direccionFacturacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Cliente asCliente() {
		return new Cliente(login,null,preferencias,nombre,direccion,direccionEnvio,direccionFacturacion,telefono);
	}

}
