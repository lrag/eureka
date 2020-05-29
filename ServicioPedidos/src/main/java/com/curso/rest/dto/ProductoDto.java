package com.curso.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;
import com.curso.modelo.entidad.Producto;

@XmlRootElement
public class ProductoDto {

	private Integer id;
	private String nombre;
	private String fabricante;
	private Double precio;
	private Integer existencias;

	public ProductoDto() {
		super();
	}

	public ProductoDto(Integer id, String nombre, String fabricante, Double precio, Integer existencias) {
		super();
		this.id          = id;
		this.nombre      = nombre;
		this.fabricante  = fabricante;
		this.precio      = precio;
		this.existencias = existencias;
	}

	public ProductoDto(Producto producto) {
		id          = producto.getId();
		nombre      = producto.getNombre();
		fabricante  = producto.getFabricante();
		precio      = producto.getPrecio();
		existencias = producto.getExistencias();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}
	
	public Producto asProducto() {
		return new Producto(id, nombre, fabricante, precio, existencias);
	}

}
