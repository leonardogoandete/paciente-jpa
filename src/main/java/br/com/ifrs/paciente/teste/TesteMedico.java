package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.MedicoDAO;
import br.com.ifrs.paciente.model.Medico;
import br.com.ifrs.paciente.model.Paciente;

public class TesteMedico {
    public static void main(String[] args) {

//        Medico medico = new Medico("Leon","RS-34567","Fisiatra");
//        new MedicoDAO().salvar(medico);
        //System.out.println(new MedicoDAO().listarTodos());

//        Medico med = new MedicoDAO().buscarPorId(2l);
//        med.setCrm("SC-1234");
//        new MedicoDAO().atualizar(med);

//        System.out.println(med);
        new MedicoDAO().salvar(new Medico("Bidu","CRM/MG-1023", "Clinico Geral"));
    }
}
