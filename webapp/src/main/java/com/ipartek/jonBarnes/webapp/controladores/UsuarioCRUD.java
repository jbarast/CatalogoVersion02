//UsuarioCRU.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet para el CRUD de la clase usuario.
 * 
 * @author jonBarnes
 * @version 28/06/2017
 */
public class UsuarioCRUD extends HttpServlet {
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
	 * Funcionamiento de la Servlet.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Instanciamos la DAO de usuarios.
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Recogemos los datos de la aplicacion.
		ServletContext application = getServletContext();

		UsuarioDAO dal = (UsuarioDAO) application.getAttribute("dalUsuarios");

		// Que hacer si la dao esta vacio.

		if (dal == null) {
			//
			application.setAttribute("dalUsuarios", usuarioDAO);
		}

		// Operaciones.
		String op = request.getParameter("op");
		if (op == null) {

			// Cogemos todos los usuarios.
			Usuario[] usuarios;
			usuarios = usuarioDAO.findAll();

			request.setAttribute("usuarios", usuarios);

			request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_USUARIO).forward(request, response);

		} else {

			// Miramos la id.
			String id = request.getParameter("id");

			// El usuario.
			Usuario usuario;

			// Operaciones alta,update y delete.
			switch (op) {
			case "modificar":
			case "borrar":

				usuario = usuarioDAO.findById(Integer.parseInt(id));

				request.setAttribute("usuario", usuario);

			case "alta":
				request.getRequestDispatcher(ConstantesGlobales.RUTA_FORMULARIO_USUARIO).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO_USUARIO).forward(request, response);
			}
		}

	}
}
