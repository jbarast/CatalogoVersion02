package com.ipartek.jonBarnes.DAL.pruebas;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Producto;

import java.math.BigDecimal;

public class ProductoTest {


    public static void main(String[] args) {

        // Creamos unos usuarios de muestra.

        ProductoDAO productoDAO = new ProductoDAO();


        //Probamos el findbyusername

        //Producto productoBD = productoDAO.findByUsername("Pelicula Indiano Jones El arca perdida");

        // Producto pelicula02 = new Producto("nombre","Describimos",12,new BigDecimal("0.01"),"rutaImagen");

        //productoDAO.insert(pelicula02);

        Producto producto = productoDAO.findByUsername("nombre");

        System.out.println(producto);


    }

}

