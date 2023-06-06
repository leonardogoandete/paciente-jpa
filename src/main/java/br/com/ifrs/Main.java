package br.com.ifrs;


import br.com.ifrs.dao.PessoaDAO;
import br.com.ifrs.model.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Leo","Travessa B");

        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.salvar(p1);



        System.out.println("Hello world!");
    }



}