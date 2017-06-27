package com.ipartek.jonBarnes.DAL;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ipartek.jonBarnes.DAL.interfaces.UsuarioInterfaceDAO;
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

	// Constructor.
	public UsuarioDAO() {
		// Cuando inicie el dao, que instancie el manager y el emf.
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
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
		// Para insertar un ROL.
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();

	}

	@Override
	public void delete(Usuario usuario) {

		// Para borrar un elemento.
		manager.getTransaction().begin();
		manager.remove(usuario);
		manager.getTransaction().commit();

	}

	@Override
	public void delete(long idUsuario) {

		// Primero buscamos el usuario.
		Usuario usuario = new Usuario();
		usuario = this.findById(idUsuario);

		// Borramos el usuario.
		this.delete(usuario);

	}

	@Override
	public void update(Usuario usuario) {

		// 1º-Buscamos el usuario.
		Usuario usuarioBD = new Usuario();
		usuarioBD = this.findByUsername(usuario.getUsername());

		usuarioBD.setNombreCompleto(usuario.getNombreCompleto());
		usuarioBD.setPassword(usuario.getPassword());

	}

	@Override
	public Usuario[] findAll() {

		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) manager.createQuery("FROM Usuario").getResultList();

		return usuarios.toArray(new Usuario[usuarios.size()]);

	}

	@Override
	public Usuario findById(long idUsuario) {
		return manager.find(Usuario.class, idUsuario);

	}

	@Override
	public Usuario findByUsername(final String username) {

		// Creamos la variable bien.
		String usernameCompleto = String.format("\'%s\'", username);
		System.out.println("username:  " + usernameCompleto);

		// Creamos la query.
		Query query = manager.createQuery("FROM Usuario where username = :username");

		query.setParameter("username", username);

		// Ejecutamos la query.
		return (Usuario) query.getSingleResult();

	}

	@Override
	public boolean validate(Usuario usuario) {

		// La variable que devolvemos.
		boolean usuarioValido = false;

		// Primero tenemos que sacar el usuario de la base de datos.
		Usuario usuarioBD = new Usuario();
		usuarioBD = this.findByUsername(usuario.getUsername());

		// Miramos que sean iguales.

		if (usuario.equals(usuarioBD)) {
			usuarioValido = true;
		}

		return usuarioValido;
	}
}
