//ListaProductosFormServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Carrito;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet, lo que hace es aï¿½adir un producto al carrito.
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
	 * Si tengo una operacion aï¿½adir metelo en el carrito.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// La "application"
		ServletContext applicationProductos = getServletContext();
		ProductoDAO dalProductos = (ProductoDAO) applicationProductos.getAttribute("dalProductos");

		// La sesion.
		HttpSession session = request.getSession();

		// EL carrito.
		List<Carrito> carrito = new ArrayList<Carrito>();
		carrito = (ArrayList<Carrito>) session.getAttribute("carrito");

		// El carrito en este moments.
		System.out.println("Carrito inicializado: " + carrito);
		// op.
		String op = request.getParameter("opform");
		// TODO puenteo
		op = "anadir";

		System.out.println("*****************************************************");
		System.out.println("*************************" + op + "*********************");
		System.out.println("*****************************************************");

		System.out.println(op);
		// Cogiendo los datos
		String id = request.getParameter("id");

		// Si la dal es null o carrito null.
		if (dalProductos == null) {

			dalProductos = new ProductoDAO();
			applicationProductos.setAttribute("dalProductos", dalProductos);
		}

		// Si no hay op, mostramos los productos.
		if (op == null) {
			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_PRODUCTOS_USUARIO).forward(request, response);

			return;

			// Si tenemos que aï¿½adir un producto al carrito.
		} else if (op.equals("anadir")) {

			// Cargamos el producto.
			Producto productoAnadir = dalProductos.findById(Long.parseLong(id));

			System.out.println("Id del producto : " + id);

			// Creamos el carrito.
			Carrito carritoAnadir = new Carrito(productoAnadir, 1);

			System.out.println("Producto a añadir: " + carritoAnadir);
			carrito.add(carritoAnadir);

			// Para ver el carrito.
			for (Carrito carritoPantalla : carrito)
				System.out.println(carritoPantalla);

			session.setAttribute("carrito", carrito);

			// Volvemos a la pagina listaproductos.
			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_PRODUCTOS_USUARIO).forward(request, response);

		}

	}

}
