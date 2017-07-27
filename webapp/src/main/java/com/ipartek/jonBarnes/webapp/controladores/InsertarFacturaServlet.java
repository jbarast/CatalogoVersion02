//InsertarFacturaServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import com.ipartek.jonBarnes.DAL.FacturaDAO;
import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Carrito;
import com.ipartek.jonBarnes.tipos.Factura;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.tipos.Usuario;
import com.ipartek.jonBarnes.webapp.variablesglobales.ConstantesGlobales;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Servlet que lo que hara sera, insertar los datos del carrito en la base de datos.
 *
 * @author jonBarnes
 * @version 27/07/2017
 */
@WebServlet(name = "insertarfactura")
public class InsertarFacturaServlet extends HttpServlet {


    /**
     * Metodo doGet que lo que hace es llamar al metodo doPost().
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
     * Metodo doPost. Se encarga de recoger los datos del carrito, meterlos en la base de datos y borrar el carrito.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Primero leer los datos del carrito. Por lo que tendremos que leer tambian los datos de la session.

        // Session.
        HttpSession session = request.getSession();
        Usuario usuarioSession = (Usuario) session.getAttribute("usuario");
        List<Carrito> carritoSession = (ArrayList<Carrito>) session.getAttribute("carrito");


        //Datos para comprobar que estan bien recogidos los datos.
        System.out.println("El usuario es: " + usuarioSession);
        System.out.println("Su carrito es: " + carritoSession);

        //Segundo lo tenemos que pasar a factura.
        Factura facturaSession = new Factura();

        //La metemos en la base de datos.
        FacturaDAO facturaDAO = new FacturaDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //Lo elementos de una factura.
        facturaSession.setUsuario(usuarioDAO.findByUsername(usuarioSession.getUsername()));
        facturaSession.setDate(new Date()); //TODO Mirar esto bien.

        //Convertimos Carrito a Producto.

        List<Producto> listaProductosCarrito = new ArrayList<Producto>();

        int carritoSize = carritoSession.size();

        for (int i = 0; i < carritoSize; i++) {

            //Enprincipio funciona. Mirarlo bien.
            listaProductosCarrito.add(productoDAO.findByUsername(carritoSession.get(i).getProducto().getNombre()));
        }

        facturaSession.setProductos(carritoSession);

        //Miramos que este bien creado.
        System.out.println("La factura es: " + facturaSession);






        facturaDAO.insert(facturaSession);

        //borramos todos por si acaso.
        usuarioSession = null;
        carritoSession = null;
        facturaSession = null;

        //Metemos el carrito.
        request.setAttribute("carrito", carritoSession);
        //El rediccionamiento.
        request.getRequestDispatcher(ConstantesGlobales.RUTA_INSERTAR_FACTURA).forward(request, response);
        return;


    }
}
