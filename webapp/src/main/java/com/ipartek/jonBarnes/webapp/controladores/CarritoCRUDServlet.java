package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.jonBarnes.tipos.Carrito;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Created by JAVA on 30/06/2017.
 */

public class CarritoCRUDServlet extends HttpServlet {

	/**
	 * Con este metodo llamamos a al metodo doPost.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * Metodo principal de la Servlet. Con esto vemos el carrito.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// La "application"
		// ServletContext application = getServletContext();

		// La sesion.
		HttpSession session = request.getSession();

		// EL carrito.
		ArrayList<Carrito> carrito;
		carrito = (ArrayList<Carrito>) session.getAttribute("carrito");
		// op.
		String op = request.getParameter("opform");

		// TODO quitar esto.
		for (Carrito carritoProducto : carrito)
			System.out.println("El carrito" + carritoProducto);

		// Las operaciones.
		// Si no hay op, mostramos los productos.

		if (op == null) {

			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_CARRITO).forward(request, response);

			return;
		}

	}

}
