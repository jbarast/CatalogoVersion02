//CarritoTest.java

package com.ipartek.jonBarnes.tipos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;


/**
 * Test para la clase Carrito.
 *
 * @author jonBarnes
 * @version 21/07/2017
 *
 */
public class CarritoTest {

    //atributos.
    Carrito carrito;

    @Before
    public void setUp() throws Exception {

        //instanciamos la clase carrito.
        //String nombre, String descripcion, int stock, BigDecimal precio, String rutaImagen, int cantidad
        carrito = new Carrito("ProductoCarrito","Producto muy pero que muy bueno",10,new BigDecimal(25),"La imagen donde andara",25);
    }

    @After
    public void tearDown() throws Exception {

        //"Borramos" el carrito.
        carrito = null;
    }


    //Para probar el set y get de cantidad.
    @Test
    public void getCantidad() throws Exception {

        assertEquals("Fallo en el getCantidad()",25,(int)carrito.getCantidad());
    }

    @Test
    public void setCantidad() throws Exception {

        assertEquals("Fallo en el getCantidad() en el metodo setCantidad()",25,(int)carrito.getCantidad());
        carrito.setCantidad(125);
        assertEquals("Fallo en el setCantidad()",125,(int)carrito.getCantidad());
    }

    //Test del metodo toString().
    @Test
    public void testToString() throws Exception {

        String carritoToStringEsperado = "Carrito{Producto: " + carrito.getNombre() + "cantidad=" + 25 + '}';

        assertEquals("Fallo en el metodo toString()",carritoToStringEsperado,carrito.toString());
    }

    //Test del metodo equals().
    @Test
    public void testEquals() throws Exception {

        Carrito carrito02 = new Carrito("ProductoCarrito","Producto muy pero que muy bueno",10,new BigDecimal(25),"La imagen donde andara",25);

       assertTrue("Fallo en el metodo equals()",carrito.equals(carrito02));

    }

}