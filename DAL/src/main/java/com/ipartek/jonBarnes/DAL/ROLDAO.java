//ROLDAO.java

package com.ipartek.jonBarnes.DAL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.jonBarnes.DAL.interfaces.ROLInterfaceDAO;
import com.ipartek.jonBarnes.tipos.ROL;

/**
 * DAO para ROL
 * 
 * @author jonBarnes
 * @version 23/06/2017
 *
 */
public class ROLDAO implements ROLInterfaceDAO {

	// Atributos necesarios.
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	// Constructor.
	public ROLDAO() {

		// Cuando inicie el dao, que instancie el manager y el emf.
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
	}

	@Override
	public void insert(ROL rol) {

		// Para insertar un ROL.
		manager.getTransaction().begin();
		manager.persist(rol);
		manager.getTransaction().commit();

	}

	@Override
	public void delete(ROL rol) {
		// TODO Auto-generated method stub

	}

	@Override
	public ROL[] findAll() {

		// List<ROL> roles = (LIST<ROL>)
		// manager.createQuery("FROM roles").getResultList();
		return null;
	}

}
