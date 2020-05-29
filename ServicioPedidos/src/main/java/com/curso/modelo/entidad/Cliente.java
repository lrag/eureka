package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {

	@Id
	private String login;
	private String nombre;
	private String direccionEnvio;
	private String direccionFacturacion;
	private String telefono;

	public Cliente() {
		super();
	}

	public Cliente(String login, String nombre, String direccionEnvio, String direccionFacturacion, String telefono) {
		super();
		this.login = login;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
