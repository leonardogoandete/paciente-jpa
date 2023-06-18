package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Consulta;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class ConsultaDAO {
    private EntityManager entityManager;
    public void salvar(Consulta consulta) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(consulta);
            entityManager.getTransaction().commit();
            System.out.println("Consulta salva com sucesso!");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar consulta:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Consulta consulta) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(consulta);
            entityManager.getTransaction().commit();
            System.out.println("Consulta atualizada com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar a consulta:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Consulta consulta) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            consulta = entityManager.merge(consulta);
            entityManager.remove(consulta);
            entityManager.getTransaction().commit();
            System.out.println("Consulta removida com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover consulta:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Consulta buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Consulta.class, id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar consulta por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Consulta buscarPorHorario(Date horario) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT c FROM Consulta c WHERE c.horario = :horario", Consulta.class)
                    .setParameter("horario",horario)
                    .getSingleResult();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar consulta por horario:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Consulta> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar consultas:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
