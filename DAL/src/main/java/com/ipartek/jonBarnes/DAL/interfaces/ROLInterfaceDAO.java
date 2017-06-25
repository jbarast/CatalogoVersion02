//ROLInterfaceDAO.java

package com.ipartek.jonBarnes.DAL.interfaces;

import com.ipartek.jonBarnes.tipos.ROL;
import com.sun.istack.internal.NotNull;

/**
 * 
 * Interface para la capa DAO de la Tabla roles.
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
public interface ROLInterfaceDAO {

	// Añadir un rol a la tabla.
	public void insert(ROL rol);

	// Borrar un rol de la tabla
	public void delete(ROL rol);

	// Mostrar la lista de roles.
	public ROL[] findAll();

	//Buscar por id.
	public ROL findByID(Long id);

	//Buscar por rol.
	public ROL finByRol(@NotNull final  String rol);

}
