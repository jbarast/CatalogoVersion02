//ROLDAO.java

package com.ipartek.jonBarnes.DAL;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ipartek.jonBarnes.DAL.interfaces.ROLInterfaceDAO;
import com.ipartek.jonBarnes.tipos.ROL;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

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
		//Para borrar el objeto.
		manager.getTransaction().begin();
		manager.remove(rol);
		manager.getTransaction().commit();
	}

	/**
	 * Nos devuelve la tabla entera.
	 * @return
	 */
	@Override
	public ROL[] findAll() {


		//Nota: Se ponen el nombre de la clase no de la tabla. Si no error.
		ArrayList<ROL> roles = (ArrayList<ROL>)manager.createQuery("FROM ROL").getResultList();
		//for (ROL rol : roles) {
		//	System.out.println(rol.toString());
		//}
		return roles.toArray(new ROL[roles.size()]);
	}

	/**
	 * Tipica buscque por Id.
	 * @param id
	 * @return
	 */
	@Override
	public ROL findByID(Long id) {
		return manager.find(ROL.class,id);
	}

	/**
	 * Nos da el objeto ROL que coincide con el rol que queremos.
	 * @param rol
	 * @return
	 */
	@Override
	public ROL finByRol(@NotNull final  String rol){

		//Un metodo un poco estraño.

		//Creamos la query.
		Query query = manager.createQuery("FROM ROL where rol = :rol");
		query.setParameter("rol",rol);

		//Ejecutamos la query.
		return (ROL)query.getSingleResult();
	}



}
