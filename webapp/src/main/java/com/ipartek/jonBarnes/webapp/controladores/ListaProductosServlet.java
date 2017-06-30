//ListaProductosServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet para la vista de compras de productos.
 * 
 * @author jonBarnes
 * @version 30/06/2017
 */
public class ListaProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Llamamos al metodo doPost().
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * En este metodo lo que vemos es la vista de compras de productos.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Primero recogemos los datos...??
		ServletContext applicationProductos = getServletContext();
		ProductoDAO dalProductos = (ProductoDAO) applicationProductos.getAttribute("dalProductos");

		// Miramos que la dalProductos no este vacia.
		if (dalProductos == null) {

			// Cargamos los productos de la base de datos.
			dalProductos = new ProductoDAO();

			applicationProductos.setAttribute("dalProductos", dalProductos);
		}

		// Creamos op.
		String op = request.getParameter("op");
		String id = request.getParameter("id");

		if (op == null) {

			// Sacamos la lista de productos.
			Producto[] productos = dalProductos.findAll();

			request.setAttribute("productos", productos);
			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_PRODUCTOS_USUARIO).forward(request, response);

		} else if (op.equals("anadir")) {

			// Creamos el objeto.
			Producto producto;

			producto = dalProductos.findById(Integer.parseInt(id));
			request.setAttribute("producto", producto);
			request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_FORMULARIO_PRODUCTOS_USUARIO).forward(request,
					response);

		}

	}

}
