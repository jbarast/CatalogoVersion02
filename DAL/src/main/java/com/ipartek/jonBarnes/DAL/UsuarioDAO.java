package com.ipartek.jonBarnes.DAL;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ipartek.jonBarnes.DAL.interfaces.UsuarioInterfaceDAO;
import com.ipartek.jonBarnes.tipos.ROL;
import com.ipartek.jonBarnes.tipos.Usuario;

//import com.sun.istack.internal.NotNull;

/**
 *
 * DAO para la clase usuario.
 *
 * @author jonBarnes
 * @version 24/06/2017
 */
public class UsuarioDAO implements UsuarioInterfaceDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos:
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	/**
	 * Constructor vacio para el DAO de usuario.
	 */
	public UsuarioDAO() {

	}

	/**
	 * Metodo para abrir la conexion.
	 */
	public void iniciarConexion() {
		// Cuando inicie el dao, que instancie el manager y el emf.
		emf = Persistence.createEntityManagerFactory("PersistenceSQLServer");
		manager = emf.createEntityManager();
	}

	/**
	 * Metodo para cerrar la conexion.
	 */
	public void cerrarConexion() {
		manager.close();
		emf.close();
	}

	// Otros metodos.

	/**
	 * Para insertar un usuario en la tabla.
	 * 
	 * @param usuario
	 *            Usuario a insertar.
	 */
	@Override
	public void insert(Usuario usuario) {

		// abrir conexion.
		iniciarConexion();
		// Primero cargamos el rol.
		ROLDAO rolDAO = new ROLDAO();
		ROL rolUsuario;

		rolUsuario = rolDAO.finByRol("Usuario");
		usuario.setId_roles(rolUsuario);

		// Para insertar un ROL.
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
		// manager.close();

		// Cerramos las conexiones.
		cerrarConexion();

	}

	@Override
	public void delete(Usuario usuario) {

		// abrimos la conexion.
		iniciarConexion();

		// para probar algunas cosas.
		System.out.println("El usuario que se va a borrar : " + usuario);
		// Para borrar un elemento.
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();

		// Cerramos la conexion.
		cerrarConexion();

	}

	@Override
	public void delete(long idUsuario) {

		// abrimos la conexion.
		iniciarConexion();

		// Primero buscamos el usuario.
		Usuario usuario = new Usuario();
		usuario = this.findById(idUsuario);

		// Borramos el usuario.
		this.delete(usuario);

		// Cerramos la conexion.
		cerrarConexion();

	}

	@Override
	public void update(Usuario usuario) {

		// Abrimos la conexion.
		iniciarConexion();

		// 1º-Buscamos el usuario.
		Usuario usuarioBD = new Usuario();
		usuarioBD = this.findByUsername(usuario.getUsername());

		usuarioBD.setNombreCompleto(usuario.getNombreCompleto());
		usuarioBD.setPassword(usuario.getPassword());

		// Cerramos la conexion.
		cerrarConexion();

	}

	@Override
	public Usuario[] findAll() {

		// abrimos la conexion.
		iniciarConexion();

		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) manager.createQuery("FROM Usuario").getResultList();

		// cerramos la conexion.
		cerrarConexion();

		// Devolvemos todos los usuarios que hay en la base de datos.
		return usuarios.toArray(new Usuario[usuarios.size()]);

	}

	@Override
	public Usuario findById(long idUsuario) {

		// abrimos la conexion.
		iniciarConexion();

		Usuario usuario = manager.find(Usuario.class, idUsuario);

		// cerramos la conexion.
		cerrarConexion();

		// Return
		return usuario;

	}

	@Override
	public Usuario findByUsername(final String username) {

		// abrimos la conexion.
		iniciarConexion();

		// Creamos la variable bien.
		String usernameCompleto = String.format("\'%s\'", username);
		System.out.println("username:  " + usernameCompleto);

		// Creamos la query.
		Query query = manager.createQuery("FROM Usuario where username = :username");

		query.setParameter("username", username);

		// Ejecutamos la query.
		Usuario usuario = (Usuario) query.getSingleResult();

		// cerramos la conexion.
		cerrarConexion();

		// Return
		return usuario;

	}

	@Override
	public boolean validate(Usuario usuario) {

		// Abrimos la conexion.
		iniciarConexion();

		// La variable que devolvemos.
		boolean usuarioValido = false;

		// Primero tenemos que sacar el usuario de la base de datos.
		Usuario usuarioBD = new Usuario();
		usuarioBD = this.findByUsername(usuario.getUsername());

		// Miramos que sean iguales.Para que sean iguales el username y las
		// password tienen que coincidir.

		if (usuario.getUsername().equals(usuarioBD.getUsername())
				&& usuario.getPassword().equals(usuarioBD.getPassword())) {
			usuarioValido = true;
		}

		// Cerramos la conexion.
		cerrarConexion();

		// Return
		return usuarioValido;
	}
}
