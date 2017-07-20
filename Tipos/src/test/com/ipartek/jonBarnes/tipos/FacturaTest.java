//FacturaTest.java

package com.ipartek.jonBarnes.tipos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Test para testear Factura
 *
 * @author jonBarnes
 * @version 20/07/2017
 */
public class FacturaTest {

    //Atributos.
    Factura factura;
    Producto producto;
    Usuario usuario;
    ROL rol;

    List<Carrito> productos;
    Carrito carrito01;
    Carrito carrito02;
    Carrito carrito03;

    Date date;


    @Before
    public void setUp() throws Exception {

        //Instanciamos.

        producto = new Producto("articuloTooMolon", "El mejor producto del munto", 10, new BigDecimal(125.25), "ruta de imagen");
        producto.setId(15L);
        rol = new ROL("usuario", "Usuario del sistema");
        rol.setId(12L);

        //Lista de productos en el carrito.
        productos = new ArrayList<Carrito>();

        ////Creamos los Productos que vamos a añadir a la lista de productos.
        //Constructor String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen, int cantidad
        carrito01 = new Carrito("carrito01", "El carrito malo", 2, new BigDecimal(11), "Ruta imagen01", 2);
        carrito01.setId(1L);
        carrito02 = new Carrito("carrito02", "El carrito bueno", 4, new BigDecimal(22), "Ruta imagen02", 10);
        carrito02.setId(2L);
        carrito03 = new Carrito("carrito03", "El carrito feo", 8, new BigDecimal(33), "Ruta imagen03", 100);
        carrito03.setId(3L);

        //Añadimos los carritos a productos.
        productos.add(carrito01);
        productos.add(carrito02);
        productos.add(carrito03);


        usuario = new Usuario(10L, rol, "UsuarioPrueba", "password", "Nombre Completo");
        date = new Date(18 / 02 / 2017);


        //Con todos ustedes la famosa factura.
        factura = new Factura(usuario, productos, date);
        factura.setId(796L);
    }

    @After
    public void tearDown() throws Exception {

        //Pasamos a null los atributos despues de cada test.
        factura = null;
        producto = null;
        usuario = null;
        rol = null;

        productos = null;
        carrito01 = null;
        carrito02 = null;
        carrito03 = null;

        date = null;

    }

    //test get y set id.
    @Test
    public void getId() throws Exception {

        assertEquals("Fallo en getId()", 796L, (long) factura.getId());
    }

    @Test
    public void setId() throws Exception {

        assertEquals("Fallo en getId() en el metodo setId()", 796L, (long) factura.getId());
        factura.setId(25L);
        assertEquals("Fallo en setId()", 25L, (long) factura.getId());

    }


    //Probamos get y set Usuario.
    @Test
    public void getUsuario() throws Exception {

        assertEquals("Fallo en getUsuario()", usuario, factura.getUsuario());
    }

    @Test
    public void setUsuario() throws Exception {

        assertEquals("Fallo en getUsuario()", usuario, factura.getUsuario());

        //Metemos un usuario nuevo.
        Usuario usuario02 = new Usuario();
        usuario02.setUsername("Cambiado");
        factura.setUsuario(usuario02);

        //Comprobacion.
        assertEquals("Fallo en setUsario()", usuario02, factura.getUsuario());

    }

    //probando get y set Date.
    @Test
    public void getDate() throws Exception {

        assertEquals("Fallo en Date", new Date(18 / 02 / 2017), factura.getDate());
    }

    @Test
    public void setDate() throws Exception {

        assertEquals("Fallo en Date", new Date(18 / 02 / 2017), factura.getDate());
        factura.setDate(new Date(05 / 15 / 1998));
        assertEquals("Fallo en Date", new Date(05 / 15 / 1998), factura.getDate());
    }


    //Para probar los get y set de Productos.

    @Test
    public void getProductos() throws Exception {
        assertEquals("Fallo en getProductos()", productos, factura.getProductos());
    }

    @Test
    public void setProductos() throws Exception {
        assertEquals("Fallo en getProductos()", productos, factura.getProductos());
        ////
        //Constructor String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen, int cantidad
        Carrito carrito05 = new Carrito("carrito01", "El carrito malo", 2, new BigDecimal(11), "Ruta imagen01", 2);
        carrito05.setId(6L);
        Carrito carrito06 = new Carrito("carrito02", "El carrito bueno", 4, new BigDecimal(22), "Ruta imagen02", 10);
        carrito06.setId(7L);
        Carrito carrito07 = new Carrito("carrito03", "El carrito feo", 8, new BigDecimal(33), "Ruta imagen03", 100);
        carrito07.setId(15L);

        //Productos02
        List<Carrito> productos02 = new ArrayList<Carrito>();

        //Añadimos los carritos a productos.
        productos02.add(carrito05);
        productos02.add(carrito06);
        productos02.add(carrito07);

        //Metemos la lista de productos en facturas.
        factura.setProductos(productos02);

        ////
        assertEquals("Fallo en getProductos()", productos02, factura.getProductos());

    }



    //TODO mejorar el test.
    @Test
    public void testToString() throws Exception {

        String facturaToStringEsperado = "Factura{" +
                "id=" + 796L +
                ", usuario=" + usuario +
                ", productos=" + productos +

                ", fecha=" + date +
                '}';

        assertEquals("Fallo el metodo toString()",facturaToStringEsperado,factura.toString());
    }

    @Test
    public void testEquals() throws Exception {

        //Instanciamiento.
        Factura factura02;
        Producto producto02;
        Usuario usuario02;
        ROL rol02;

        List<Carrito> productos05;
        Carrito carrito012;
        Carrito carrito022;
        Carrito carrito032;

        Date date02;

        //Instanciamos.

        producto02 = new Producto("articuloTooMolon", "El mejor producto del munto", 10, new BigDecimal(125.25), "ruta de imagen");
        producto02.setId(15L);
        rol02= new ROL("usuario", "Usuario del sistema");
        rol02.setId(12L);

        //Lista de productos en el carrito.
        productos05 = new ArrayList<Carrito>();

        ////Creamos los Productos que vamos a añadir a la lista de productos.
        //Constructor String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen, int cantidad
        carrito012 = new Carrito("carrito01", "El carrito malo", 2, new BigDecimal(11), "Ruta imagen01", 2);
        carrito012.setId(1L);
        carrito022 = new Carrito("carrito02", "El carrito bueno", 4, new BigDecimal(22), "Ruta imagen02", 10);
        carrito022.setId(2L);
        carrito032 = new Carrito("carrito03", "El carrito feo", 8, new BigDecimal(33), "Ruta imagen03", 100);
        carrito032.setId(3L);

        //Añadimos los carritos a productos.
        productos05.add(carrito01);
        productos05.add(carrito02);
        productos05.add(carrito03);


        usuario02 = new Usuario(10L, rol, "UsuarioPrueba", "password", "Nombre Completo");
        date02 = new Date(18 / 02 / 2017);


        //Con todos ustedes la famosa factura.
        factura02 = new Factura(usuario, productos, date);
        factura02.setId(796L);

        //Comprobacion
        assertTrue("Fallo castastrofico en equals()",factura.equals(factura02));



    }

}