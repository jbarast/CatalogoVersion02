package com.ipartek.jonBarnes.DAL.pruebas;

import com.ipartek.jonBarnes.DAL.ROLDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Usuario;

/**
 * Clase para crear diferentes elementos de UsuariosDAO.
 */
public class UsuarioTest {

	public static void main(String[] args) {

		// Creamos unos usuarios de muestra.

		ROLDAO rolDAO = new ROLDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		Usuario usuario = new Usuario("Usuario04", "pass014", "Nombre Completo usuario4");

		Usuario usuarioImprimir = new Usuario();

		usuarioDAO.insert(usuario);

		usuarioImprimir = usuarioDAO.findByUsername("Usuario04");

		System.out.println(usuarioImprimir);

		usuario.setPassword("pass06Nuevo");

		usuarioDAO.update(usuario);

		usuarioImprimir = usuarioDAO.findByUsername("Usuario04");

		System.out.println(usuarioImprimir);

	}
}
