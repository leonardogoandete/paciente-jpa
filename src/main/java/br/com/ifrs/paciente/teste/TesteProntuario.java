package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.ProntuarioDAO;
import br.com.ifrs.paciente.model.Prontuario;

import java.util.Date;

public class TesteProntuario {
    public static void main(String[] args) {
        //Prontuario prontuario = new Prontuario(new Date(),"Prontuario do teste Leonardo");

        //new ProntuarioDAO().salvar(prontuario);

        Prontuario pt = new ProntuarioDAO().buscarPorId(2l);
        //Prontuario pt2 = new Prontuario(pt.getData(),pt.getDescricao());
        //System.out.println(pt.toString());
        new ProntuarioDAO().remover(pt);
    }
}
