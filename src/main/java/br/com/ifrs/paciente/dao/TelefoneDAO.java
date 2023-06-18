package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Telefone;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TelefoneDAO {
    private EntityManager entityManager;
    public void salvar(Telefone telefone) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(telefone);
            entityManager.getTransaction().commit();
            System.out.println("Telefone salvo com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar o telefone:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Telefone telefone) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(telefone);
            entityManager.getTransaction().commit();
            System.out.println("Telefone atualizado com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar o telefone:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Telefone telefone) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            telefone = entityManager.merge(telefone);
            entityManager.remove(telefone);
            entityManager.getTransaction().commit();
            System.out.println("Telefone removido com sucesso");
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover telefone:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Telefone buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Telefone.class, id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar telefone por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Telefone buscarPorNumero(long numero) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT t FROM Telefone t WHERE t.numero = :numero", Telefone.class)
                    .setParameter("numero", numero)
                    .getSingleResult();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar telefone por numero:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Telefone> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT t FROM Telefone t", Telefone.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar telefones:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}
