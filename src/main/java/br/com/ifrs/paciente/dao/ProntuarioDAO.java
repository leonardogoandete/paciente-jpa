package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Prontuario;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ProntuarioDAO {

    public void salvar(Prontuario prontuario) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(prontuario);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Prontuario prontuario) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(prontuario);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Prontuario prontuario) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            prontuario = entityManager.merge(prontuario);
            entityManager.remove(prontuario);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Prontuario buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Prontuario.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Prontuario> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Prontuario p", Prontuario.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
}
