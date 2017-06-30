//ListaProductosFormServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Carrito;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet, lo que hace es a�adir un producto al carrito.
 * 
 * @author jonBarnes
 * @version 30/06/2017
 * 
 */
public class ListaProductosFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Llama al metodo doPost().
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 
	 * Si tengo una operacion a�adir metelo en el carrito.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// La "application"
		ServletContext applicationProductos = getServletContext();
		ProductoDAO dalProductos = (ProductoDAO) applicationProductos.getAttribute("dalProductos");

		// EL carrito.
		List<Carrito> carrito = null;
		// op.
		String op = request.getParameter("opform");

		// Cogiendo los datos
		String id = request.getParameter("id");

		// Si la dal es null o carrito null.
		if (dalProductos == null) {

			dalProductos = new ProductoDAO();
			applicationProductos.setAttribute("dalProductos", dalProductos);
		}

		if (carrito == null) {

			carrito = new ArrayList<Carrito>();
			applicationProductos.setAttribute("carrito", carrito);
		}

		// Si no hay op, mostramos los productos.
		if (op == null) {
			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_PRODUCTOS_USUARIO).forward(request, response);

			return;

			// Si tenemos que a�adir un producto al carrito.
		} else if (op.equals("anadir")) {

			//Cargamos el producto.
			Producto productoAnadir = dalProductos.findById(Long.parseLong(id));

			//Creamos el carrito.
			Carrito carritoAnadir = new Carrito(productoAnadir,1);

			carrito.add(carritoAnadir);

			//Volvemos a la pagina listaproductos.
			request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO_PRODUCTOS_USUARIO).forward(request,response);

		}

	}

}
