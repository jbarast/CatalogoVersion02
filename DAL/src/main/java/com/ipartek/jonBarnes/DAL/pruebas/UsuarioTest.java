package com.ipartek.jonBarnes.DAL.pruebas;

import com.ipartek.jonBarnes.DAL.ROLDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.DAL.interfaces.UsuarioInterfaceDAO;
import com.ipartek.jonBarnes.tipos.Usuario;

/**
 * Clase para crear diferentes elementos de UsuariosDAO.
 */
public class UsuarioTest {

	public static void main(String[] args) {

		// Creamos unos usuarios de muestra.

		ROLDAO rolDAO = new ROLDAO();
		UsuarioInterfaceDAO usuarioDAO = new UsuarioDAO();

		Usuario[] usuarios;

		Usuario usuario02 = new Usuario();

		usuario02.setUsername("Jon");
		usuario02.setPassword("pass");

		usuarioDAO.insert(usuario02);

		usuarios = usuarioDAO.findAll();

		usuarioDAO.update(usuario02);
		usuario02.setNombreCompleto("Modificado");

		usuarios = usuarioDAO.findAll();

		for (Usuario usuario : usuarios)
			System.out.println(usuario);

	}
}
