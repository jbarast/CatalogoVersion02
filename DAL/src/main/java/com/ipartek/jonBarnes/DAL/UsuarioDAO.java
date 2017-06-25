package com.ipartek.jonBarnes.DAL;

import com.ipartek.jonBarnes.DAL.interfaces.UsuarioInterfaceDAO;
import com.ipartek.jonBarnes.tipos.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * DAO para la clase usuario.
 *
 * @author jonBarnes
 * @version 24/06/2017
 */
public class UsuarioDAO implements UsuarioInterfaceDAO{

    //Atributos:
    private static EntityManager manager;
    private static EntityManagerFactory emf;


    //Constructor.
    public UsuarioDAO() {
        // Cuando inicie el dao, que instancie el manager y el emf.
        emf = Persistence.createEntityManagerFactory("Persistencia");
        manager = emf.createEntityManager();
    }

    //Otros metodos.


    /**
     * Para insertar un usuario en la tabla.
     * @param usuario  Usuario a insertar.
     */
    @Override
    public void insert(Usuario usuario) {
        // Para insertar un ROL.
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public void delete(long idUsuario) {

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public Usuario[] findAll() {
        return new Usuario[0];
    }

    @Override
    public void findById(long idUsuario) {

    }

    @Override
    public void findByUsername(String username) {

    }

    @Override
    public boolean validate(Usuario usuario) {
        return false;
    }
}
