//LoginServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

/**
 * Servlet para la vista login.
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Creamos la dao.
	public static UsuarioDAO daoUsuario = null;

	/**
	 * 
	 * El meotodo doGet llama al metodo doPost.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * 
	 * Metodo para llevar acabo el login.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		// Session.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(ConstantesGlobales.TIEMPO_INACTIVIDAD);

		// Llamamos a la dao.
		daoUsuario = new UsuarioDAO();

		// Recoger datos de vistas
		String username = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String opcion = request.getParameter("opcion");

		// Con estos datos creo un usuario.
		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setUsername(username);
		usuarioLogin.setPassword(pass);

		// Booleans.
		boolean sinParametros = usuarioLogin.getUsername() == null;
		try {

			// Miramos que hayan metido un dato
			if (sinParametros) {
				request.getRequestDispatcher(ConstantesGlobales.RUTA_LOGIN).forward(request, response);
			} else {
				// Validamos el usuario.
				// Prueba para saber que valida bien.
				if (daoUsuario.validate(usuarioLogin)) {
					// TODO borrar el print.
					System.out.println("Usuario Valido");

					// Metemos el usuario en la session.
					Usuario usuarioAmeter = new Usuario();
					usuarioAmeter = daoUsuario.findByUsername(usuarioLogin.getUsername());
					session.setAttribute("usuario", usuarioAmeter);

					// rediccionamiento.
					response.sendRedirect("/productocrud");
				} else {
					System.out.println("Usuario no valido, Prueba otra vez.");

					// Operacion a realizar cuando el usuario no es valido.

					request.setAttribute("usuario", usuarioLogin);
					request.getRequestDispatcher(ConstantesGlobales.RUTA_LOGIN).forward(request, response);

				}

			}

		} catch (Exception e) {

		}

	}
}
