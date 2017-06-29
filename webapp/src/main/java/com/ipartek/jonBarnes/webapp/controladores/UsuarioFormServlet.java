//usuarioform.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet para el usuarioform.
 * 
 * @author jonBarnes
 * @version 28/06/2017
 */
public class UsuarioFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * El metodo doGet llama al metodo doPost.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 
	 * Funcionamiento del Servlet.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// operacion a realizar.
		String op = request.getParameter("opform");

		// Id
		String id = request.getParameter("id");

		// Datos del objeto que queremos modificar borrar o dar de alta.
		String ussername = request.getParameter("username");
		String nombreCompleto = request.getParameter("nombreCompleto");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");

		// Las rutas.
		RequestDispatcher rutaListado = request.getRequestDispatcher(ConstantesGlobales.RUTA_SERVLET_LISTADO_USUARIO);
		RequestDispatcher rutaFormulario = request.getRequestDispatcher(ConstantesGlobales.RUTA_FORMULARIO_USUARIO);

		// Operacion nula, mostrar listado de usuarios.
		if (op == null) {
			rutaListado.forward(request, response);
			return;
		}

		// Cogemos el objeto de la aplicacion, usurio.
		Usuario usuario = new Usuario();
		usuario.setUsername(ussername);
		usuario.setPassword(pass);
		usuario.setNombreCompleto(nombreCompleto);

		//
		ServletContext application = getServletContext();
		UsuarioDAO dal = (UsuarioDAO) application.getAttribute("dalUsuarios");

		// Miramos si la dal esta vacia.
		if (dal == null) {
			application.setAttribute("dalUsuarios", dal);
		}

		// Creamos el manager.
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		// Las operaciones.
		try {
			switch (op) {
			case "alta":
				if (pass.equals(pass2)) {

					usuarioDAO.insert(usuario);

					rutaListado.forward(request, response);
				} else {
					// Que hacer si las contrase�as no coinciden.
					// usuario.setErrores("Las contrase�as no coinciden");
					request.setAttribute("usuario", usuario);
					rutaFormulario.forward(request, response);
				}

				break;
			case "modificar":
				if (pass.equals(pass2)) {
					try {

						System.out
								.println("***************************************************************************");
						System.out
								.println("************************************UPDATE UPDATE**************************");
						System.out
								.println("***************************************************************************");
						Usuario usuarioModificar;

						usuarioModificar = usuarioDAO.findById(Long.parseLong(id));
						System.out.println("******" + usuarioModificar + "*******");
						// Cambiamos la contrase�a al usuario.
						usuarioModificar.setPassword(pass);
						usuarioModificar.setNombreCompleto(nombreCompleto);

						System.out.println(usuarioModificar);
						// Modificamos el usuario.
						usuarioDAO.update(usuarioModificar);
						// redireccion.
						rutaFormulario.forward(request, response);
					} catch (Exception de) { // Error.
						// usuario.setErrores(de.getMessage());
						request.setAttribute("usuario", usuario);
						rutaFormulario.forward(request, response);
						return;
					}
					rutaListado.forward(request, response);
				} else {
					// Contrase�as no coinciden.
					// usuario.setErrores("Las contrase�as no coinciden");
					request.setAttribute("usuario", usuario);
					rutaFormulario.forward(request, response);
				}

				break;
			case "borrar":

				usuario = usuarioDAO.findByUsername(usuario.getUsername());

				// Indicamos que usuario se borra.
				// log.info(String.format("Borrado el usuario %s.", nombre));

				// Borramos el usuario.
				usuarioDAO.delete(usuario.getId()); // Prabando el metodo
													// DELETE.
				rutaListado.forward(request, response);

				break;



			}
		} catch (Exception e) {

			try {
				throw new Exception("Error en operar con la base de datos.", e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}
}
