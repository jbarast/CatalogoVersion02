package com.ipartek.jonBarnes.webapp.controladores;

import com.ipartek.jonBarnes.DAL.FacturaDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Factura;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Metodo para visualizar las facturas de un usuario.
 * Aunque digamos que es un crud por ley no se pueden borrar facturas ni modificarlas, por la que solo veremos las facturas.
 *
 * @author jonBarnes
 * @version 26/07/2017
 *
 *
 */
@WebServlet(name = "listafacturas")
public class FacturaCRUDServlet extends HttpServlet {


    /**
     * Metodo doGet lo unico que hace es llamar al metodo doPost().
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }


    /**
     * Metodo doPost().
     * En este metodo lo que aparecera sera la lista de facturas del usuario de la session.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1º-Necesitamos saber el usuario de la session.

        // Session.
        HttpSession session = request.getSession();
        Usuario usuarioSession = (Usuario) session.getAttribute("usuario");

        //Para saber si el usuario esta bien cogido.
        System.out.println(usuarioSession);

        //2º-Iniciamos la DAO.
        FacturaDAO facturaDAO = new FacturaDAO();

        // Recogemos los datos de la aplicacion.
        ServletContext application = getServletContext();

        FacturaDAO dalFacturas = (FacturaDAO) application.getAttribute("dalFacturas");

        // Que hacer si la dao esta vacio.

        if (dalFacturas == null) {
            //
            application.setAttribute("dalFacturas", facturaDAO);
        }

        //3º-Recogemos la operacion a realizar.
        String op = request.getParameter("op");


        //4º-Operaciones a realizar dependiendo de op.

        if(op==null){
            // Cogemos todos las facturas.
            Factura[] facturas;
            facturas = facturaDAO.findAll();

            request.setAttribute("facturas", facturas);

            request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_FACTURAS).forward(request, response);

        }




    }


}
