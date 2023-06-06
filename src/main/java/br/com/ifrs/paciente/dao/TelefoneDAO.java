package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Telefone;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TelefoneDAO {

    public void salvar(Telefone telefone) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(telefone);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Telefone telefone) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(telefone);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Telefone telefone) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            telefone = entityManager.merge(telefone);
            entityManager.remove(telefone);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Telefone buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Telefone.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Telefone> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT t FROM Telefone t", Telefone.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
}
