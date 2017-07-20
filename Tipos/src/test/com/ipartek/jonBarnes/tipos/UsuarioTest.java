package com.ipartek.jonBarnes.tipos;

import static org.junit.Assert.*;

import com.ipartek.jonBarnes.tipos.ROL;

public class UsuarioTest {

    //Atributos generales.
    ROL rol;
    Usuario usuario;


    @org.junit.Before
    public void setUp() throws Exception {
        //Creamos la clase Usuario.
        rol = new ROL("usuario", "Usuario del sistema");
        rol.setId(12L);

        usuario = new Usuario(10L, rol, "UsuarioPrueva", "password", "Nombre Completo");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        //Vaciamos los datos.
        usuario = null;
        rol = null;
    }


    //Los teses.
    @org.junit.Test
    public void getId() throws Exception {

        assertEquals("Fallo en el getID()", 10L, usuario.getId());
    }

    @org.junit.Test
    public void setId() throws Exception {
        assertEquals("Fallo en el getID() en el metodo setID()", 10L, usuario.getId());
        usuario.setId(25L);
        assertEquals("Fallo en el setID()", 25L, usuario.getId());


    }

    //TODO terminar estos tests.

    @org.junit.Test
    public void testGetId_roles() throws Exception {
        assertEquals("Fallo en el getROL()", rol,usuario.getId_roles());
    }

    @org.junit.Test
    public void setId_roles() throws Exception {

        assertEquals("Fallo en el getROL() en setRol()", rol,usuario.getId_roles());

        ROL rol02 = new ROL("usuarioMod", "Usuario del sistemaMod");
        usuario.setId_roles(rol02);
        rol02.setId(5L);

        assertEquals("Fallo en el setROL() ", rol02,usuario.getId_roles());



    }



    @org.junit.Test
    public void getUsername() throws Exception {

        assertEquals("Fallo en el getUsername()", "UsuarioPrueva", usuario.getUsername());
    }

    @org.junit.Test
    public void setUsername() throws Exception {
        assertEquals("Fallo en el getUsername() en el setUsername()", "UsuarioPrueva", usuario.getUsername());
        usuario.setUsername("NuevoUsuario");
        assertEquals("Fallo en el setUsername()", "NuevoUsuario", usuario.getUsername());

    }

    @org.junit.Test
    public void getPassword() throws Exception {

        assertEquals("Fallo en getPassword()", "password", usuario.getPassword());
    }

    @org.junit.Test
    public void setPassword() throws Exception {
        assertEquals("Fallo en getPassword() en el metodo setPassword()", "password", usuario.getPassword());
        usuario.setPassword("NuevoPassword");
        assertEquals("Fallo en setPassword()", "NuevoPassword", usuario.getPassword());
    }

    @org.junit.Test
    public void getNombreCompleto() throws Exception {

        assertEquals("Fallo en getNombreCompleto()","Nombre Completo",usuario.getNombreCompleto());
    }

    @org.junit.Test
    public void setNombreCompleto() throws Exception {
        assertEquals("Fallo en getNombreCompleto() en setNombreCompleto()","Nombre Completo",usuario.getNombreCompleto());
        usuario.setNombreCompleto("ModificadoNombreCompleto");
        assertEquals("Fallo en setNombreCompleto()","ModificadoNombreCompleto",usuario.getNombreCompleto());
    }

    @org.junit.Test
    public void testToString() throws Exception {

        String usuarioToStringEsperado = "Usuario [id=" + 10L + ", id_roles=" + rol + ", username=" + "UsuarioPrueva" + ", password=" + "password"
                + ", nombreCompleto=" + "Nombre Completo" + "]" ;

        assertEquals("Fallo en el metodo toString()", usuarioToStringEsperado,usuario.toString());
    }

    /*
    @org.junit.Test
    public void testHashCode() throws Exception {
    }
    */

    @org.junit.Test
    public void testEquals() throws Exception {

        Usuario usuario02 = new Usuario(10L, rol, "UsuarioPrueva", "password", "Nombre Completo");

        assertTrue(usuario.equals(usuario02));
    }


}