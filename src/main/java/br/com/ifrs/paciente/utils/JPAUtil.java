package br.com.ifrs.paciente.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager(){
        if (emf == null) emf = Persistence.createEntityManagerFactory("aulaJPA");
        return emf.createEntityManager();
    }

    public void fechaEntityManager(){
        emf.close();
    }
}
