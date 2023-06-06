package br.com.ifrs.paciente.dao;

import br.com.ifrs.paciente.model.Pessoa;
import br.com.ifrs.paciente.utils.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaDAO {

    public void salvar(Pessoa pessoa) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void atualizar(Pessoa pessoa) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void remover(Pessoa pessoa) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.merge(pessoa);
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Pessoa buscarPorId(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.find(Pessoa.class, id);
        } finally {
            entityManager.close();
        }
    }

    public List<Pessoa> listarTodos() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
}

