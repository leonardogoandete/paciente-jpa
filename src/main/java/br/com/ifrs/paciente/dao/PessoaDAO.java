package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Pessoa;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaDAO {
    private EntityManager entityManager;
    public void salvar(Pessoa pessoa) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao salvar pessoa:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Pessoa pessoa) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao atualizar pessoa:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public void remover(Pessoa pessoa) {
        try {
            entityManager = JPAUtil.getEntityManager();
            entityManager.getTransaction().begin();
            pessoa = entityManager.merge(pessoa);
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao remover pessoa:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    public Pessoa buscarPorId(Long id) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.find(Pessoa.class, id);
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar pessoa por ID:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    public List<Pessoa> buscarPorNome(String nome) {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE :nome", Pessoa.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao buscar pessoas por nome:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }



    public List<Pessoa> listarTodos() {
        try {
            entityManager = JPAUtil.getEntityManager();
            return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.out.println("Erro ao listar pessoas:\n"+ e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }
}

