//ROLDAOTest.java

package com.ipartek.jonBarnes.DAL;

import com.ipartek.jonBarnes.tipos.ROL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test para el DAO de la entidad ROL.
 *
 * @author jonBarnes
 * @version 21/07/2017
 *
 */
public class ROLDAOTest {

    //Atributos.
    ROL rol;
    ROLDAO rolDao;

    @Before
    public void setUp() throws Exception {

        //instanciamos.
        rol = new ROL("usuario", "Usuario del sistema");
        rol.setId(12L);

        rolDao = new ROLDAO();
    }

    @After
    public void tearDown() throws Exception {

        rol = null;
        rolDao.cerrarConexion();
}


    //Tests para probar el crud de rolDAO.
    //Como hostias hacerlo sin afectar la base de datos.
    @Test
    public void insert() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByID() throws Exception {
    }

    @Test
    public void finByRol() throws Exception {
    }

}