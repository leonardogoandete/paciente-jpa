package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Medico;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MedicoDAO {
    private EntityManager entityManager;
    public void salvar(Medico medico) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(medico);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar o Medico:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Medico medico) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(medico);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar o medico:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Medico medico) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            medico = entityManager.merge(medico);
            entityManager.remove(medico);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover medico:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Medico buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Medico.class, id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar medico por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Medico buscarPorCrm(String crm) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT m FROM Medico m WHERE m.crm = :crm", Medico.class)
                    .setParameter("crm",crm)
                    .getSingleResult();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar medico por CRM:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Medico> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar medicos:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
