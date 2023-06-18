package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Prontuario;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class ProntuarioDAO {
    private EntityManager entityManager;
    public void salvar(Prontuario prontuario) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(prontuario);
            entityManager.getTransaction().commit();
            System.out.println("Prontuario salvo com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar o prontuario:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Prontuario prontuario) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(prontuario);
            entityManager.getTransaction().commit();
            System.out.println("Prontuario salvo com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar o prontuario:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Prontuario prontuario) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            prontuario = entityManager.merge(prontuario);
            entityManager.remove(prontuario);
            entityManager.getTransaction().commit();
            System.out.println("Prontuario removido com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover prontuario:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Prontuario buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Prontuario.class, id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar prontuario por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Prontuario> buscarPorData(Date data) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Prontuario p WHERE p.data = :data", Prontuario.class)
                    .setParameter("data",data)
                    .getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar prontuario por data:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Prontuario> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Prontuario p", Prontuario.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar prontuarios:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
