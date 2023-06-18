package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Paciente;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PacienteDAO {
    private EntityManager entityManager;
    public void salvar(Paciente paciente) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar o paciente:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Paciente paciente) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(paciente);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar o paciente:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Paciente paciente) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            paciente = entityManager.merge(paciente);
            entityManager.remove(paciente);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover paciente:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Paciente buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Paciente.class,id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar paciente por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Paciente> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar pacientes:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Paciente> buscarPorNome(String nome) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Paciente p WHERE p.nome LIKE :nome", Paciente.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar pacientes por nome:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
