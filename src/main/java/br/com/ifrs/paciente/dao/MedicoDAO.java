package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Medico;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MedicoDAO {

    public void salvar(Medico medico) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(medico);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Medico medico) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(medico);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Medico medico) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            medico = entityManager.merge(medico);
            entityManager.remove(medico);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Medico buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Medico.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Medico> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
}
