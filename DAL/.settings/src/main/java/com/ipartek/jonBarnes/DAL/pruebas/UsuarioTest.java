package com.ipartek.jonBarnes.DAL.pruebas;

import com.ipartek.jonBarnes.DAL.ROLDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.DAL.interfaces.UsuarioInterfaceDAO;
import com.ipartek.jonBarnes.tipos.ROL;
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

		//Creacion del usuario lista de usuario.
		Usuario usuario = new Usuario();
		Usuario usuarioAdmin = new Usuario();

		//Creacion del admin
		usuarioAdmin.setUsername("admin");
		usuarioAdmin.setPassword("admin");
		ROL rolAdmin = rolDAO.finByRol("admin");
		usuarioAdmin.setId_roles(rolAdmin);
		usuarioAdmin.setNombreCompleto("Administrador del sistema");

		//Insertamos el admin.
		usuarioDAO.insert(usuarioAdmin);

		//Creacion de la lista de usuarios.
		ROL rolUsurio = rolDAO.finByRol("usuario");

		String passUsuario = null;
		String usernameUsuario = null;
		String nombreCompletoUsuario = null;

		for(int i=0; i<200; i++){

			//Creamos los datos.
			passUsuario = String.format("usuariopass%d",i);
			usernameUsuario= String.format("usuario%d",i);
			nombreCompletoUsuario = String.format("usuarioCompleto%d",i);

			//Lo metemos en el usuario.
			usuario.setPassword(passUsuario);
			usuario.setUsername(usernameUsuario);
			usuario.setId_roles(rolUsurio);
			usuario.setNombreCompleto(nombreCompletoUsuario);

			//Insertamos en la base de datos.
			usuarioDAO.insert(usuario);
		}


		//Mostramos todos los usuarios.
		usuarios = usuarioDAO.findAll();

		for(Usuario usuarioLista: usuarios)
			System.out.println(usuarioLista);


	}
}
