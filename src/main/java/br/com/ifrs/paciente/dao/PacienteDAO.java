package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Paciente;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PacienteDAO {

    public void salvar(Paciente paciente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Paciente paciente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(paciente);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Paciente paciente) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            paciente = entityManager.merge(paciente);
            entityManager.remove(paciente);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Paciente buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Paciente.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Paciente> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Paciente> buscarPorNome(String nome) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE :nome", Paciente.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }

}
