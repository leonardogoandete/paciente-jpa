package br.com.ifrs.dao;

import br.com.ifrs.model.Pessoa;
import br.com.ifrs.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaDAO {
    EntityManager em = JPAUtil.getEntityManager();
    public void salvar(Pessoa pessoa) {
        // Lógica para salvar a pessoa no banco de dados
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Salvou o jaguara");
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Nao salvou o jaguara");
        }finally {
        em.close();
        JPAUtil.getEntityManager().close();
    }
    }

    public void atualizar(Pessoa pessoa) {
        // Lógica para atualizar a pessoa no banco de dados
    }

    public void excluir(Pessoa pessoa) {
        // Lógica para excluir a pessoa do banco de dados
    }

    public List<Pessoa> listar() {
        // Lógica para listar todas as pessoas do banco de dados
        return null;
    }

    public Pessoa buscarPorId(int id) {
        // Lógica para buscar uma pessoa por ID no banco de dados
        return null;
    }
}
