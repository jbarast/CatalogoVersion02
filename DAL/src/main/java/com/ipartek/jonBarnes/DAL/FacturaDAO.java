//FacturaDAO.java

package com.ipartek.jonBarnes.DAL;


import com.ipartek.jonBarnes.DAL.interfaces.FacturaInterfaceDAO;
import com.ipartek.jonBarnes.tipos.Factura;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.tipos.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * DAO para las facturas.
 *
 * @author jonBarnes
 * @version 20/07/2017
 */
public class FacturaDAO implements FacturaInterfaceDAO {

    //Atributos necesarios.
    private static EntityManager manager;
    private static EntityManagerFactory managerFactory;
    private static EntityTransaction transaction;

    //Constructor
    public FacturaDAO() {
        conexion();

    }

    //Getters y setters.

    //OTros metodos.

    //Metodos de la interfaz.

    //Metodo de instanciamiento.
    public void conexion() {
        managerFactory = Persistence.createEntityManagerFactory("PersistenceSQLServer");
        manager = managerFactory.createEntityManager();

        transaction = manager.getTransaction();
    }

    public void cerrarManagers() {
        manager.close();
        managerFactory.close();
    }


    /**
     * Metodo antiguo de inserte, tiene un error.
     * @param factura
     */
    @Override
    public void insertConERROR(Factura factura) {

        transaction.begin();
        manager.merge(factura);
        transaction.commit();

    }

    /**
     *
     * Metodo para insertar.
     * Mirarlo bastante bien.
     *
     * @param factura pasamos la factura que queremos meter.
     */
    @Override
    public void insert(Factura factura){

        //Metemo los datos que necesitamos.

        transaction.begin();

        Factura facturaToInsert = new Factura();

        for (Producto producto: factura) {
            facturaToInsert.getProductos().add(producto);

        }




    }

    //TODO mirar esto muy bien.
    @Override
    public void delete(Factura factura) {

        transaction.begin();

        manager.remove(factura);
        transaction.commit();



    }

    @Override
    public Factura[] findAll() {


        ArrayList<Factura> facturas = (ArrayList<Factura>) manager.createQuery("FROM Factura ").getResultList();


        return facturas.toArray(new Factura[facturas.size()]);

    }

    @Override
    public Factura[] findFacturasCliente(Usuario cliente) {



        //Cogemos la Factura.
        TypedQuery<Factura> consultaFactura = manager.createQuery("select a from Factura a where a.id = :idUsuario", Factura.class);

        //TODO no entindo bien el cambio hecho.
        List<Factura> facturasCliente = new ArrayList<Factura>((Collection<? extends Factura>) consultaFactura.setParameter("idUsuario", cliente.getId()));



        return facturasCliente.toArray(new Factura[facturasCliente.size()]);
    }

    @Override
    public Factura findByID(Long id) {


        Factura factura = manager.find(Factura.class, id);



        return factura;
    }


}
