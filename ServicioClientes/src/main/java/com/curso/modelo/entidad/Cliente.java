package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Cliente {

	@Id
	private String login;
	//@NotEmpty
	private String password;
	private String preferencias;
	@NotEmpty
	private String nombre;
	private String direccion;
	@NotEmpty
	private String direccionEnvio;
	private String direccionFacturacion;
	@NotEmpty
	private String telefono;

	public Cliente() {
		super();
	}

	public Cliente(String login) {
		super();
		this.login = login;
	}

	public Cliente(String login, String password, String preferencias, String nombre, String direccion,
			String direccionEnvio, String direccionFacturacion, String telefono) {
		super();
		this.login = login;
		this.password = password;
		this.preferencias = preferencias;
		this.nombre = nombre;
		this.direccion = direccion;
		this.direccionEnvio = direccionEnvio;
		this.direccionFacturacion = direccionFacturacion;
		this.telefono = telefono;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
