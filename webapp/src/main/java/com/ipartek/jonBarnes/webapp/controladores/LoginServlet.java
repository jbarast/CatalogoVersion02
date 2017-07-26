//LoginServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

		// A partir de aqui no borrarlo.
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

		// Leemos datos de la session.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// Session.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(ConstantesGlobales.TIEMPO_INACTIVIDAD);

		// Llamamos a la dao.
		daoUsuario = new UsuarioDAO();

		// Recoger datos de vistas
		String username = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String opcion = request.getParameter("opcion");

		// System.out.println de comprobaciones.
		System.out.println("Opcion= " + opcion);

		// Con estos datos creo un usuario.
		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setUsername(username);
		usuarioLogin.setPassword(pass);

		// Haciendo pruebas.
		// Codigo seguramente no tan bueno.

		// Booleans.
		boolean sinParametros = usuarioLogin.getUsername() == null && !("logout".equals(opcion));
		boolean quiereSalir = "logout".equals(opcion);
		try {

			// Miramos que hayan metido un dato
			if (sinParametros) {
				System.out.println(getServletContext().getRealPath("/"));
				System.out.println(getServletContext().getContextPath());
				System.out.println(ConstantesGlobales.RUTA_LOGIN);

				request.getRequestDispatcher(ConstantesGlobales.RUTA_LOGIN).forward(request, response);
				return;

			} else if (quiereSalir) {
				// Finalizamos la session.
				session.invalidate();
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
					response.sendRedirect("/productoscrud");
				} else {
					System.out.println("Usuario no valido, Prueba otra vez.");

					// Operacion a realizar cuando el usuario no es valido.

					request.setAttribute("usuario", usuarioLogin);
					request.getRequestDispatcher(ConstantesGlobales.RUTA_LOGIN).forward(request, response);
					return;

				}

			}

		} catch (Exception e) {

		}

	}
}
