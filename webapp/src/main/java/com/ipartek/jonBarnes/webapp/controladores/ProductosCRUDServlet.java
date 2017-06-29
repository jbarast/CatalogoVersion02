//ProductosCRUDServlet.java

package com.ipartek.jonBarnes.webapp.controladores;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ProductosCRUDServlet
 */
public class ProductosCRUDServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Llamamos al metodo doPost().
     *
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * Metodo principal de la servlet.
     *
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
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

        //Borrar este carrito.
        //Carrito profesional.
        List<Carrito> carritos = null;

        try {
            if (op == null) {

                Producto[] productos = dalProductos.findAll();
                // Miramos como da el dato.
                // Por si queremos ver los productos que tenemos en el log.
                for (int i = 0; i < productos.length; i++) {
                    // log.info(String.format("Que tiene el carrito?? %s",
                    // productos[i]));
                }
                request.setAttribute("productos", productos);
                request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO).forward(request, response);
            } else {

                // System.out.println(request.getParameter("id"));

                String id = request.getParameter("id");
                System.out.println("El di del getParameter: " + id);
                // System.out.println(id);

                Producto producto;

                switch (op) {
                    case "modificar":
                    case "borrar":
                        producto = dalProductos.findById(Integer.parseInt(id));
                        request.setAttribute("producto", producto);
                    case "alta":
                        request.getRequestDispatcher(ConstantesGlobales.RUTA_FORMULARIO).forward(request, response);
                        break;

                    //Añadir productos al carro.
                    case "anadir":

                        request.getRequestDispatcher(ConstantesGlobales.RUTA_FORMULARIO).forward(request, response);

                        break;

                    default:
                        request.getRequestDispatcher(ConstantesGlobales.RUTA_LISTADO).forward(request, response);
                }
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
