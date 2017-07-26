package com.ipartek.jonBarnes.DAL.interfaces;

import java.io.Serializable;

import com.ipartek.jonBarnes.tipos.Usuario;

/**
 * Interfaz para la DAO de la clase Usuario.
 *
 * @version 24/06/2017
 * @autor jonBarnes
 */
public interface UsuarioInterfaceDAO extends Serializable {

	// Los metodos que tine que que tener la clase.

	// Añadir un usuario a la tabla.
	public void insert(Usuario usuario);

	// Borrar un usuario de la tabla
	public void delete(Usuario usuario);

	// Borrar un usuario de la tablo por id.
	public void delete(long idUsuario);

	// Update un usuario de la tabla.
	public void update(Usuario usuario);

	// Mostrar la lista de roles.
	public Usuario[] findAll();

	// Buscar por id.
	public Usuario findById(long idUsuario);

	// Buscar por username.
	public Usuario findByUsername(String username);

	// Validar login.
	public boolean validate(Usuario usuario); // Nos dice si es un usuario de la
												// base de datos.

}
