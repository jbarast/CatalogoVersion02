package com.ipartek.jonBarnes.webapp.controladores;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Carrito;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAVA on 30/06/2017.
 */

public class CarritoCRUDServlet extends HttpServlet {


    /**
     * Con este metodo llamamos a al metodo doPost.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }


    /**
     * Metodo principal de la Servlet. Con esto vemos el carrito.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // La "application"
        ServletContext application = getServletContext();




        // EL carrito.
        List<Carrito> carrito = null;
        // op.
        String op = request.getParameter("opform");


        //Si es la primera vez que carga, que carge el carrito.
        if (carrito == null) {

            carrito = (ArrayList<Carrito>) application.getAttribute("carrito");


        }

        //Las operaciones.
        // Si no hay op, mostramos los productos.
        if (op == null) {

            for(Carrito carritoArray: carrito){
                System.out.println(carritoArray);
            }
            request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_CARRITO).forward(request, response);

            return;
        }

    }

}
