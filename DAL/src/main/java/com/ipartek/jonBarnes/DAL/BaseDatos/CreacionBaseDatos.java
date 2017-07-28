//CreacionBaseDatos.java

package com.ipartek.jonBarnes.DAL.BaseDatos;

import com.ipartek.jonBarnes.DAL.ProductoDAO;
import com.ipartek.jonBarnes.DAL.ROLDAO;
import com.ipartek.jonBarnes.DAL.UsuarioDAO;
import com.ipartek.jonBarnes.tipos.Producto;
import com.ipartek.jonBarnes.tipos.ROL;
import com.ipartek.jonBarnes.tipos.Usuario;

import java.math.BigDecimal;

/**
 * Clase para crear la base de datos.
 *
 * @author jonBarnes
 * @version 28/07/2017
 */
public class CreacionBaseDatos {


    public static void main(String[] args) {

        //Abrimos los dao.
        ROLDAO roldao = new ROLDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProductoDAO productoDAO = new ProductoDAO();

        //Creacion de los roles

        //Creacion de los roles.
        ROL rol01 = new ROL("admin", "Administrador del sistema");
        ROL rol02 = new ROL("usuario", "Usuario del sistema");

        //Metemos en la base de datos.

        roldao.insert(rol01);
        roldao.insert(rol02);


        //Creacion de los usuario.


        Usuario[] usuarios;

        //Creacion del usuario lista de usuario.
        Usuario usuario = new Usuario();
        Usuario usuarioAdmin = new Usuario();

        //Creacion del admin
        usuarioAdmin.setUsername("admin");
        usuarioAdmin.setPassword("admin");
        ROL rolAdmin = roldao.finByRol("admin");
        usuarioAdmin.setId_roles(rolAdmin);
        usuarioAdmin.setNombreCompleto("Administrador del sistema");

        //Insertamos el admin.
        usuarioDAO.insert(usuarioAdmin);

        //Creacion de la lista de usuarios.
        ROL rolUsurio = roldao.finByRol("usuario");

        //Atributos necesarios para la creacion de la base de datos.
        String passUsuario = null;
        String usernameUsuario = null;
        String nombreCompletoUsuario = null;

        for (int i = 0; i < 200; i++) {
            //Creamos los datos.
            passUsuario = String.format("usuariopass%d", i);
            usernameUsuario = String.format("usuario%d", i);
            nombreCompletoUsuario = String.format("usuarioCompleto%d", i);

            //Lo metemos en el usuario.
            usuario.setPassword(passUsuario);
            usuario.setUsername(usernameUsuario);
            usuario.setId_roles(rolUsurio);
            usuario.setNombreCompleto(nombreCompletoUsuario);

            //Insertamos en la base de datos.
            usuarioDAO.insert(usuario);
        }


        //Creacion de los productos.

        Producto producto01 = new Producto("EL manuscrito Voynich", "El libro mas enigmatico del que se tienen noticias.\t", 1, new BigDecimal("1508490"), "http://www.todolibroantiguo.es/libros-raros/astronomica.jpg");
        Producto producto02 = new Producto("El codex gigas", "La biblia encargada por el propio Satanas.\t", 1, new BigDecimal("1669.0984"), "http://www.todolibroantiguo.es/libros-raros/codex-gigas-biblia-diablo.jpg");
        Producto producto03 = new Producto("Astronomicum Caesareum\t", "Libro de Astronomia del emperador Carlos I\t", 1, new BigDecimal("5989.02"), "http://www.todolibroantiguo.es/libros-raros/menu1.jpg");
        Producto producto04 = new Producto("Biblia Poliglota Complutense\t", "Una de las obras cumbres de las imprentas españolas.\t", 1, new BigDecimal("0.01"), "http://www.todolibroantiguo.es/libros-raros/hypnerotomachia-poliphili-3.jpg");
        Producto producto05 = new Producto("Necromonicon", "Libro para conquistar el mundo o por lo menos para despertar a los antiguos.\t", 1, new BigDecimal("150"), "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Necronomicon_prop.jpg/800px-Necronomicon_prop.jpg");
        Producto producto06 = new Producto("Libro de Dzyan", "El libro que llevo a la cuspide tecnologica a la atlantida\t", 1, new BigDecimal("19849"), "https://3trior.files.wordpress.com/2013/07/la-tierra.jpg?resize=640%2C552");
        Producto producto07 = new Producto("NEFER-KA-PTAH\t", "El verdadero libro del tarot. Escrito en el antiguo egipcio para controlar los cuatro elementos.\t", 1, new BigDecimal("19849.21"), "https://encrypted-tbn1.google.com/images?q=tbn:ANd9GcQZZ2n22KL0sCqt7cSO13OpT2eFHt7eogwC3JsLPkVo1LS8NWpB-g");

        //insertamos los productos en la base de datos.
        productoDAO.insert(producto01);
        productoDAO.insert(producto02);
        productoDAO.insert(producto03);
        productoDAO.insert(producto04);
        productoDAO.insert(producto05);
        productoDAO.insert(producto06);
        productoDAO.insert(producto07);


    }

}
