package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.PacienteDAO;
import br.com.ifrs.paciente.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestesMapeamentos {
    public static void main(String[] args) {
        // Teste Silvia
        //Criando paciente
        Paciente paciente = new Paciente();
        paciente.setNome("Leonardo Teste");
        paciente.setEndereco("R. Cel. Vicente, 289");
        paciente.setConvenio("Unimed UNIMAX");
        paciente.setCpf("78945612357");
        paciente.setDataNascimento(new Date(97,6,5)); // MES fazer MES-1; pois janeiro inicia em 0

        //Emails
        List<String> emails = new ArrayList<>();
        emails.add("leo@leo.com");
        emails.add("lteste@leo.com");
        paciente.setEmails(emails);

        //Telefone
        List<Telefone> telefones = new ArrayList<>();
        telefones.add(new Telefone(51,987456321L));
        telefones.add(new Telefone(53,123456789L));
        paciente.setTelefones(telefones);

        //Prontuario
        Prontuario prontuario = new Prontuario();
        prontuario.setData(new Date(97,6,21));
        prontuario.setDescricao("Prontuario do Leonardo");
        paciente.setProntuario(prontuario);

        // Situação
        paciente.setSituacao(Situacao.HOSP);

        //Medico
        Medico medico = new Medico();
        medico.setCrm("RS-12345");
        medico.setEspecialidade("Otorrinolaringologista");

        //Consulta
        List<Consulta> consultas = new ArrayList<>();
        Consulta consulta1 = new Consulta();
        consulta1.setPaciente(paciente);
        consulta1.setMedico(medico);
        consulta1.setData(new Date(123,5,16)); // MES fazer MES-1; pois janeiro inicia em 0
        consulta1.setHorario(new Date(0,0,0,15,23,00));
        consultas.add(consulta1);
        paciente.setConsultas(consultas);

        //Salvando o paciente e seus relacionamentos
        new PacienteDAO().salvar(paciente);


        //Remover Paciente por ID
//        Paciente p = new PacienteDAO().buscarPorId(5L);
//        new PacienteDAO().remover(p);


        //Atualizando paciente usando ID
//        Paciente p = new PacienteDAO().buscarPorId(9L);
//        p.setEndereco("Travessa B");
//        new PacienteDAO().atualizar(p);

        //Listar Pacientes
//        for (Paciente p: new PacienteDAO().listarTodos()) {
//            System.out.println(p.toString());
//        }

    }
}
