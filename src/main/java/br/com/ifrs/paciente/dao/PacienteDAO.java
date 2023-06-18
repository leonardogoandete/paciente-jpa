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
            System.out.println("Paciente salvo com sucesso");
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
            System.out.println("Paciente atualizado com sucesso");
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
            System.out.println("Paciente removido com sucesso");
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

    public Paciente buscarPorCpf(String cpf) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf", Paciente.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar paciente por CPF:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
