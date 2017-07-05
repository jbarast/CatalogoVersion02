package com.ipartek.jonBarnes.DAL.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.jonBarnes.DAL.ROLDAO;
import com.ipartek.jonBarnes.tipos.ROL;

/**
 * Clase para hacer diferentes pruebas de hibernate con la clase ROL.
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
public class ROLTest {

	// "atributos"??

	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {

		// Creamos el gestor de persistencia.
		emf = Persistence.createEntityManagerFactory("PersistenceSQLServer");
		manager = emf.createEntityManager();

		// Creamos un rol.

		ROL rol01 = new ROL("admin", "Administrador del sistema");
		ROL rol02 = new ROL("usuario", "Usuario del sistema");
		// ROL rol03 = new
		// ROL(5L,"usuarioPruebas","Usuario para pruebas del sistema");

		ROLDAO rolDAO = new ROLDAO();

		 rolDAO.insert(rol01);
		 rolDAO.insert(rol02);

		// rolDAO.delete(rol03);

		// Miramos como imprime los roles.
		ROL[] rolesTable;
		rolesTable = rolDAO.findAll();

		for (ROL rol : rolesTable) {
			System.out.println(rol);
		}

	}
}
