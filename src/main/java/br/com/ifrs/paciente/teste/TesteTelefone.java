package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.TelefoneDAO;
import br.com.ifrs.paciente.model.Telefone;

public class TesteTelefone {
    public static void main(String[] args) {
//        Telefone telefone = new Telefone("519911223344");
//
//        System.out.println(telefone.toString());
//        new TelefoneDAO().salvar(telefone);
//
//        System.out.println(new TelefoneDAO().listarTodos());
        System.out.println(new TelefoneDAO().listarTodos());
    }
}
