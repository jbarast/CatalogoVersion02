package com.ipartek.jonBarnes.tipos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductoTest {
    //Atributos.
    Producto producto;


    @Before
    public void setUp() throws Exception {

        //instanciamos la variable.
        producto = new Producto("articuloTooMolon", "El mejor producto del munto", 10, new BigDecimal(125.25), "ruta de imagen");
        producto.setId(5L);
    }

    @After
    public void tearDown() throws Exception {

        //vaciamos la variable.
        producto = null;
    }


    //Probando los getters y setters de id.

    @Test
    public void getId() throws Exception {

        assertEquals("Fallo en getId()", 5L, producto.getId());
    }

    @Test
    public void setId() throws Exception {

        assertEquals("Fallo en getId() en el metodo setId()", 5L, producto.getId());
        producto.setId(68L);
        assertEquals("Fallo en setId()", 68L, producto.getId());

    }


    //Probando los getters y setters de Nombre.

    @Test
    public void getNombre() throws Exception {

        assertEquals("Fallo en el getNombre()","articuloTooMolon",producto.getNombre());
    }

    @Test
    public void setNombre() throws Exception {

        assertEquals("Fallo en el getNombre()","articuloTooMolon",producto.getNombre());
        producto.setNombre("ProductoNoTxatxi");
        assertEquals("Fallo en el getNombre()","ProductoNoTxatxi",producto.getNombre());

    }


    //Probando los getters y setters de Descripcion.
    @Test
    public void getDescripcion() throws Exception {

        assertEquals("Fallo en el getDescripcion()", "El mejor producto del munto", producto.getDescripcion());

    }

    @Test
    public void setDescripcion() throws Exception {

        assertEquals("Fallo en el getDescripcion()","El mejor producto del munto",producto.getDescripcion());
        producto.setDescripcion("El objeto para controlarlos a todos");
        assertEquals("Fallo en el getDescripcion()","El objeto para controlarlos a todos",producto.getDescripcion());


    }


    //Probar los getters y setters del atributo stock.
    @Test
    public void getStock() throws Exception {

        assertEquals("Fallo en getStock",10,producto.getStock());
    }

    @Test
    public void setStock() throws Exception {

        assertEquals("Fallo en getStock en el metodo setStock()",10,producto.getStock());
        producto.setStock(452);
        assertEquals("Fallo en setStock ",452,producto.getStock());

    }

    //Probando los getter y setter del atributo Precio.

    @Test
    public void getPrecio() throws Exception {

        assertEquals("Fallo en el getPrecio()",new BigDecimal(125.25),producto.getPrecio());
    }

    @Test
    public void setPrecio() throws Exception {

        assertEquals("Fallo en el getPrecio() en el metodo setPrecio()",new BigDecimal(125.25),producto.getPrecio());
        producto.setPrecio(new BigDecimal(458.69));
        assertEquals("Fallo en el setPrecio()",new BigDecimal(458.69),producto.getPrecio());


    }


    //Probando los metodos getters y setters de RutaImagen.
    @Test
    public void getRutaImagen() throws Exception {

        assertEquals("Fallo en el getRutaImagen()","ruta de imagen",producto.getRutaImagen());
    }

    @Test
    public void setRutaImagen() throws Exception {

        assertEquals("Fallo en el getRutaImagen() en el metodo setImagen()","ruta de imagen",producto.getRutaImagen());
        producto.setRutaImagen("Donde esta la imagen");
        assertEquals("Fallo en el setRutaImagen()","Donde esta la imagen",producto.getRutaImagen());

    }


    //probando los getters y setters de facturas.
    @Test
    public void getFacturas() throws Exception {
        //TODO hacerlo
    }

    @Test
    public void setFacturas() throws Exception {
        //TODO hacerlo
    }



    @Test
    public void testToString() throws Exception {

        //El string que tiene que dar.
        String productoToStringEsperado = "Producto [id=" + 5L + ", nombre=" + "articuloTooMolon" + ", descripcion=" + "El mejor producto del munto" + ", stock=" + 10
                + ", precio=" + new BigDecimal(125.25) + ", rutaImagen=" + "ruta de imagen" + "]";

        //Comprobacion.
        assertEquals("Fallo en el metodo toString()",productoToStringEsperado,producto.toString());
    }

    @Test
    public void testEquals() throws Exception {

        //Creamos un producto igual a producto.
        Producto producto02 =  new Producto("articuloTooMolon", "El mejor producto del munto", 10, new BigDecimal(125.25), "ruta de imagen");
        producto02.setId(5L);

        //Miramos si son iguales.
        assertTrue(producto.equals(producto02));
    }

}