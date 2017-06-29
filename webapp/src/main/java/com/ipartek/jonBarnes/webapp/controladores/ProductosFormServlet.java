//ProductosFormServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Controlador para la vista productosform.jsp
 * 
 * @author jonBarnes
 * @version 29/06/2017
 */
public class ProductosFormServlet extends HttpServlet {
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
	 * Funcionamiento de la Servlet.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// La "application"
		ServletContext applicationProductos = getServletContext();
		ProductoDAO dalProductos = (ProductoDAO) applicationProductos.getAttribute("dalProductos");
		// op.
		String op = request.getParameter("opform");

		// Cogiendo los datos
		String nombre = request.getParameter("nombre");

		// Si la dal es null.
		if (dalProductos == null) {

			dalProductos = new ProductoDAO();
			applicationProductos.setAttribute("dalProductos", dalProductos);

		}

		// Descripcion.
		String descripcion = request.getParameter("descripcion");

		// Precio
		String precio = request.getParameter("precio");

		if (precio == null || precio.equals("")) {
			precio = "0";
		}

		// Cogemos el stock
		String stringStock = request.getParameter("stock");

		if (stringStock == null || stringStock.equals("")) {
			stringStock = "0";
		}

		int stock = Integer.parseInt(stringStock);

		// La ruta de la imagen.
		String rutaImagen = request.getParameter("rutaImagen");

		// Operaciones.
		// // 1º-Que no sea null.
		if (op == null) {
			request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO).forward(request, response);

			return;
		}

		// Creamos el producto.
		Producto producto = new Producto();

		// Cargamos los datos.
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);

		// Para pasar String to BigDecimal.
		// Create a DecimalFormat that fits your requirements
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);

		//
		BigDecimal bigDecimalPrecio = null;
		try {
			bigDecimalPrecio = (BigDecimal) decimalFormat.parse("precio");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setPrecio(bigDecimalPrecio);
		producto.setStock(stock);
		producto.setRutaImagen(rutaImagen);

		// Las operaciones.
		try {
			switch (op) {
			case "alta":
				try {

					// Damos de alta el producto.
					dalProductos.insert(producto);
				} catch (Exception de) {
					// producto.setErrores("El producto ya existe");
					request.setAttribute("producto", producto);
					request.getRequestDispatcher("?op=alta").forward(request, response);
					return;

				}
				request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO).forward(request, response);

				break;
			case "modificar":
				try {

					// Cogemos la id.
					producto = dalProductos.findByUsername(producto.getNombre());
					producto.setDescripcion(descripcion);

					producto.setPrecio(bigDecimalPrecio);
					producto.setStock(stock);
					producto.setRutaImagen(rutaImagen);

					// Indicamos que producto se a modificado..
					// log.info(String.format("Objeto %s modificado de la  tienda.",
					// producto.getNombre()));

					// Hacemos la modificacion.
					dalProductos.update(producto);
				} catch (Exception de) {
					// producto.setErrores(de.getMessage());
					request.setAttribute("producto", producto);
					request.getRequestDispatcher(ConstantesGlobales.RUTA_FORMULARIO).forward(request, response);
					return;
				}
				request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO).forward(request, response);

				// dalProductos.modificarProducto(producto);
				// request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO).forward(request,
				// response);

				break;
			case "borrar":

				// Cogemos la id.
				producto = dalProductos.findByUsername(producto.getNombre());

				// Indicamos que producto se a dado de alta.
				// log.info(String.format("Objeto %s borrado de la tienda.",
				// producto.getNombre()));

				// Borramos el producto.
				dalProductos.delete(producto.getId());
				request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO).forward(request, response);
				break;
			}

		} catch (Exception e) {
			// TODO arreglar esto.
			try {
				throw new Exception("Error en las operaciones con la base de datos.", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

}
