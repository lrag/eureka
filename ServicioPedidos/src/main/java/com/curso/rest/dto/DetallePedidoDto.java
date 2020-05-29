package com.curso.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DetallePedidoDto {

	private Integer id;
	private PedidoDto pedido;
	private ProductoDto producto;
	private Double precio;
	private Integer cantidad;

	public DetallePedidoDto() {
		super();
	}

	public DetallePedidoDto(Integer id, PedidoDto pedido, ProductoDto producto, Double precio, Integer cantidad) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PedidoDto getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
