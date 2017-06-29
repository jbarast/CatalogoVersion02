//ProductoDAO.java

package com.ipartek.jonBarnes.DAL;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ipartek.jonBarnes.DAL.interfaces.ProductoInterfaceDAO;
import com.ipartek.jonBarnes.tipos.Producto;

/**
 * 
 * DAO de la clase Producto.
 * 
 * @author jonBarnes
 * @version 27/06/2017
 *
 */
public class ProductoDAO implements ProductoInterfaceDAO {

	// Atributos:
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	// Constructor.
	public ProductoDAO() {
		// Cuando inicie el dao, que instancie el manager y el emf.
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
	}

	// Metodos de la interfaz.

	/**
	 * Metodo para insertar un Producto
	 */
	@Override
	public void insert(Producto producto) {
		// Para insertar un producto.
		manager.getTransaction().begin();
		manager.merge(producto);
		manager.getTransaction().commit();

	}

	/**
	 * Metodo delete.
	 * 
	 * @param producto
	 *            Producto que queremos borrar.
	 */
	@Override
	public void delete(Producto producto) {
		// Para borrar un elemento.
		manager.getTransaction().begin();
		manager.remove(producto);
		manager.getTransaction().commit();

	}

	/**
	 * Delete producto.
	 * 
	 * @param idProducto
	 *            indice del producto
	 */
	@Override
	public void delete(long idProducto) {
		// Primero buscamos el usuario.
		Producto producto = new Producto();
		producto = this.findById(idProducto);

		// Borramos el usuario.
		this.delete(producto);

	}

	/**
	 * PAra hacer el update
	 * 
	 * @param producto
	 *            producto que queremos actualizar.
	 */
	@Override
	public void update(Producto producto) {

		// 1º-Buscamos el producto.
		Producto productoBD = new Producto();

		// 2º-Cogemos el producto de la base de datos.
		productoBD = this.findByUsername(producto.getNombre());

		// 3º-Damos valor a los productos.
		productoBD.setDescripcion(producto.getDescripcion());
		productoBD.setPrecio(producto.getPrecio());
		productoBD.setStock(producto.getStock());
		productoBD.setRutaImagen(producto.getRutaImagen());

	}

	/**
	 * Encuentra todos los elementos de la base de datos.
	 */
	@Override
	public Producto[] findAll() {
		ArrayList<Producto> productos = (ArrayList<Producto>) manager.createQuery("FROM Producto").getResultList();

		return productos.toArray(new Producto[productos.size()]);
	}

	/**
	 * Busca por id el producto.
	 */
	@Override
	public Producto findById(long idProducto) {
		return manager.find(Producto.class, idProducto);
	}

	/**
	 * Busca por id del producto.
	 */
	@Override
	public Producto findByUsername(String producto) {

		// Creamos la variable bien.
		String nombreCompleto = String.format("\'%s\'", producto);
		System.out.println("Nombre del producto:  " + nombreCompleto);

		// Creamos la query.
		Query query = manager.createQuery("FROM Producto where nombre = :producto");

		query.setParameter("producto", producto);

		// Ejecutamos la query.
		Producto productoBD = (Producto) query.getSingleResult();
		return productoBD;
	}

}
