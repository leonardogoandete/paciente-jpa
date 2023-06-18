package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.PacienteDAO;
import br.com.ifrs.paciente.dao.PessoaDAO;
import br.com.ifrs.paciente.model.Pessoa;

public class TestePessoa {
    public static void main(String[] args) {
//        for (Pessoa p: new PessoaDAO().buscarPorNome("Leo")) {
//            System.out.println(p.toString());
//        }
        //System.out.println(new PessoaDAO().listarTodos());
        for (Pessoa p: new PacienteDAO().listarTodos()){
            System.out.println(p.toString()+"\n");
        }
    }
}
