package com.curso.modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "PEDIDO")

@NamedEntityGraph(
		name = "PedidoConDetalles", 
		attributeNodes = {
				@NamedAttributeNode("detalles")
		}
	)

public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Size(min=1, max=10)
	private String codigo;
	
	//@Temporal(TemporalType.DATE)
	//private LocalDate fecha;
	//A tope
	private String fecha;
	
	@NotEmpty
	private String estado;

	@ManyToOne
	@JoinColumn(name = "fk_login_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	private List<DetallePedido> detalles;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, String codigo, String fecha, String estado, Cliente cliente,
			List<DetallePedido> detalles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public void addDetalle(DetallePedido detalle) {
		//LN para a�adir el detalle
		detalles.add(detalle);
	}
	
}
