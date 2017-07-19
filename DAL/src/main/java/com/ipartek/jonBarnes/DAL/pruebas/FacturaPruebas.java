package com.ipartek.jonBarnes.DAL.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacturaPruebas {


    // Atributos necesarios.
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args){

        //Inicializo los persistences.

        // Cuando inicie el dao, que instancie el manager y el emf.
        emf = Persistence.createEntityManagerFactory("PersistenceSQLServer");
        manager = emf.createEntityManager();

        //Para indicar terminado.
        System.out.println("Operacion Terminada.");

    }
}
