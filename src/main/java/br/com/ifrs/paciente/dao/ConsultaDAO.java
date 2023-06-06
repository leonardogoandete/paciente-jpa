package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Consulta;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultaDAO {

    public void salvar(Consulta consulta) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(consulta);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Consulta consulta) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(consulta);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Consulta consulta) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            consulta = entityManager.merge(consulta);
            entityManager.remove(consulta);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Consulta buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Consulta.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Consulta> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
}
