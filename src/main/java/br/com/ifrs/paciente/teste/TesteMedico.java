package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.MedicoDAO;
import br.com.ifrs.paciente.model.Medico;
import br.com.ifrs.paciente.model.Paciente;

public class TesteMedico {
    public static void main(String[] args) {

        Medico medico = new Medico("Leon","RS-34567","Fisiatra");
        new MedicoDAO().salvar(medico);
    }
}
