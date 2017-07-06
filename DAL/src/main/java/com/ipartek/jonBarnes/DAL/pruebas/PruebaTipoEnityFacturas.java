//PruebaTipoEntityFacturas.java

package com.ipartek.jonBarnes.DAL.pruebas;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by JAVA on 06/07/2017.
 */
public class PruebaTipoEnityFacturas {

    // Atributos necesarios.
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {


        //Primero iniciamos la conexion con la base de datos.
        // Cuando inicie el dao, que instancie el manager y el emf.
        emf = Persistence.createEntityManagerFactory("PersistenceSQLServer");
    }


    static void crearDatos(){
        EntityManager manager = emf.createEntityManager();

        //Buscamos un usuario.

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();

        usuario = usuarioDAO.findByUsername("usuario125");

        //Lista de factura.
        ListaFactura listaFactura = new ListaFactura(usuario,new Date());

        //Facturas, meteremos dos.

        //Productos para los carritos.
        ProductoDAO productoDAO = new ProductoDAO();
        Producto producto01 = productoDAO.findById(206);
        Producto producto02 = productoDAO.findById(207);
        Producto producto03 = productoDAO.findById(208);
        Producto producto04 = productoDAO.findById(209);

        Carrito carrito01 = new Carrito(producto01,1);
        Carrito carrito02 = new Carrito(producto02,2);
        Carrito carrito03 = new Carrito(producto03,1);
        Carrito carrito04 = new Carrito(producto04,1);


        Factura factura01 = new Factura(carrito01,listaFactura);
        Factura factura02 = new Factura(carrito02,listaFactura);

        manager.getTransaction().begin();

        manager.getTransaction().commit();

        manager.close();
    }

    static void imprimirDatos(){
        EntityManager manager = emf.createEntityManager();


        manager.close();
    }
}
