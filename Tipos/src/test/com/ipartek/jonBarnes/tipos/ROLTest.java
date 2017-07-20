//RolTest.java

package com.ipartek.jonBarnes.tipos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test para probar el tipo ROL.
 *
 * @author jbarast
 * @version 20/07/2017
 */
public class ROLTest {

    //Atributos necesarios.
    ROL rol;

    @Before
    public void setUp() throws Exception {
        //Inicializamos el rol.

        rol = new ROL("usuario", "Usuario del sistema");
        rol.setId(12L);
    }

    @After
    public void tearDown() throws Exception {

        //vaciamos las variables.
        rol = null;
    }

    //ID.

    @Test
    public void getId() throws Exception {

        assertEquals("Fallo en getId()",12L,(long)rol.getId());
    }

    @Test
    public void setId() throws Exception {

        assertEquals("Fallo en el getId() en el test de setId()",12L,(long)rol.getId());
        rol.setId(25L);
        assertEquals(25L,(long)rol.getId());
    }

    //Rol.

    @Test
    public void getRol() throws Exception {

        assertEquals("Fallo en getRol()","usuario",(String)rol.getRol());
    }

    @Test
    public void setRol() throws Exception {

        assertEquals("Falta en getRol en el metodo setRol()","usuario",(String)rol.getRol());
        rol.setRol("rolCambiado");
        assertEquals("Fallo en setRol()","rolCambiado",(String)rol.getRol());
    }

    @Test
    public void getDescripcion() throws Exception {

        assertEquals("Fallo en getDescripcion()","Usuario del sistema",rol.getDescripcion());
    }

    @Test
    public void setDescripcion() throws Exception {

        assertEquals("Fallo en getDescripcion() en setDescripcion()","Usuario del sistema",rol.getDescripcion());
        rol.setDescripcion("CambiadoDescripcion");
        assertEquals("Fallo en setDescripcion()","CambiadoDescripcion",rol.getDescripcion());
    }


    @Test
    public void testToString() throws Exception {

        String rolToStringResultEsperado = "ROL [id=" + 12L + ", rol=" + "usuario" + ", descripcion=" + "Usuario del sistema" + "]";

        assertEquals("Fallo en el toString()",rolToStringResultEsperado,rol.toString());
    }

    /*
    @Test
    public void hashCode() throws Exception {
    }
    */

    @Test
    public void testEquals() throws Exception {

        ROL rol02 = new ROL("usuario", "Usuario del sistema");
        rol02.setId(12L);


        assertTrue(rol.equals(rol02));
    }


}