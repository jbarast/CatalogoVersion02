//ProductoInterfaceDAO.java

package com.ipartek.jonBarnes.DAL.interfaces;

import java.io.Serializable;

import com.ipartek.jonBarnes.tipos.Producto;

/**
 * Interfaz para la clase Producto.
 * 
 * @author jonBarnes
 * @version 27/06/2017
 *
 */
public interface ProductoInterfaceDAO extends Serializable {

	// Los metodos que tine que que tener la clase.

	// Añadir un usuario a la tabla.
	public void insert(Producto producto);

	// Borrar un usuario de la tabla
	public void delete(Producto producto);

	// Borrar un usuario de la tablo por id.
	public void delete(long idProducto);

	// Update un usuario de la tabla.
	public void update(Producto producto);

	// Mostrar la lista de roles.
	public Producto[] findAll();

	// Buscar por id.
	public Producto findById(long idProducto);

	// Buscar por username.
	public Producto findByUsername(String producto);

}
