package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.TelefoneDAO;
import br.com.ifrs.paciente.model.Telefone;

import java.util.Date;

public class TesteTelefone {
    public static void main(String[] args) {
//        Telefone telefone = new Telefone("519911223344");
//
//        System.out.println(telefone.toString());
//        new TelefoneDAO().salvar(telefone);
//
//        System.out.println(new TelefoneDAO().listarTodos());
//        System.out.println(new TelefoneDAO().listarTodos());
//        Telefone tel = new TelefoneDAO().buscarPorId(1L);
//        new TelefoneDAO().remover(tel);
//        System.out.println(new TelefoneDAO().listarTodos());
        new TelefoneDAO().salvar(new Telefone("51947563892"));
    }
}
