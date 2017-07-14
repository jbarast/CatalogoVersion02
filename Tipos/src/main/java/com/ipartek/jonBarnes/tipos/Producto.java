package com.ipartek.jonBarnes.tipos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * POJO producto.
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
@Entity
@Table(name = "productos", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" }) })
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos.

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "nombre", unique = true)
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "stock")
	private int stock;

	@Column(name = "precio")
	private BigDecimal precio;

	@Column(name = "Imagen")
	private String rutaImagen;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="productosFacturas", joinColumns = @JoinColumn(name = "factura_id"),inverseJoinColumns = @JoinColumn(name="producto_id"))
	private List<Factura> facturas = new ArrayList<Factura>();

	// Constructores.
	public Producto() {
		super();

	}

	public Producto(String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen) {
		super();

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.rutaImagen = rutaImagen;
	}

	// Getters y Setters.
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}


	// Otros metodos.

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + ", rutaImagen=" + rutaImagen + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((rutaImagen == null) ? 0 : rutaImagen.hashCode());
		result = prime * result + stock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (rutaImagen == null) {
			if (other.rutaImagen != null)
				return false;
		} else if (!rutaImagen.equals(other.rutaImagen))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

}
