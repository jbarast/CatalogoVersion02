package com.ipartek.jonBarnes.tipos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by JAVA on 29/06/2017.
 */
public class Carrito extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos.
	private int cantidad;

	// Constructor.

	public Carrito() {
		super();
		this.cantidad = 0;
	}

	public Carrito(int cantidad) {
		this.cantidad = cantidad;
	}

	public Carrito(String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen, int cantidad) {
		super(nombre, descripcion, stock, precio, rutaImagen);
		this.cantidad = cantidad;
	}

	public Carrito(Producto producto, int cantidad) {

		super(producto.getNombre(), producto.getDescripcion(), producto.getStock(), producto.getPrecio(), producto
				.getRutaImagen());
		this.cantidad = cantidad;
	}

	// Getters y setters.

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// Otras funciones.

	@Override
	public String toString() {
		return "Carrito{Producto: " + super.getNombre() + "cantidad=" + cantidad + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;

		Carrito carrito = (Carrito) o;

		return cantidad == carrito.cantidad;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + cantidad;
		return result;
	}
}
