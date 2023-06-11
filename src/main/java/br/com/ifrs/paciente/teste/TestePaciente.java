package br.com.ifrs.paciente.teste;


import br.com.ifrs.paciente.model.*;
import br.com.ifrs.paciente.dao.PacienteDAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestePaciente {
    public static void main(String[] args) {
//        List<String> emails = new ArrayList<>();
//        List<Telefone> telefones = new ArrayList<>();
//        List<Consulta> consultas = new ArrayList<>();
//        Prontuario prontuario = new Prontuario(new Date(),"Prontuario do Leonardo");
//        Medico medico = new Medico("Katiuscha Maria","CRM/RS 25432","Ortopedista");
//        Medico medico1 = new Medico("Josebalda Maria","CRM/RS 25433","Dentista");
//
//        telefones.add(new Telefone("514848448448"));
//        telefones.add(new Telefone("5128911681681"));
//
//        emails.add("leo@leo.com");
//        emails.add("laika@laika.com");
//
//        Paciente paciente = new Paciente("Leo", "Leo", telefones, "Unimed", "78945612354",
//                new Date(), emails, Situacao.EM_OBSER, consultas, prontuario);
//        consultas.add(new Consulta(new Date(), new Date(), paciente, medico));
//        consultas.add(new Consulta(new Date(), new Date(), paciente, medico1));
//
//        new PacienteDAO().salvar(paciente);

        System.out.println(new PacienteDAO().listarTodos());
    }

}
