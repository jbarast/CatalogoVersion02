//FacturaInterfaceDAO.java

package com.ipartek.jonBarnes.DAL.interfaces;


import com.ipartek.jonBarnes.tipos.Factura;
import com.ipartek.jonBarnes.tipos.Usuario;

/**
 * Interfaz para el DAO de facturas.
 *
 * @author jonBarnes
 * @version 20/07/2017
 */
public interface FacturaInterfaceDAO {

    // Añadir una factura a la tabla.
    public void insert(Factura factura);

    // Borrar una factura de la tabla
    public void delete(Factura factura);

    // Mostrar la lista de facturas.
    public Factura[] findAll();

    //Mostrar lista de facturas de un usuario.
    public Factura[] findFacturasCliente(Usuario cliente);

    // Buscar por id.
    public Factura findByID(Long id);


}
