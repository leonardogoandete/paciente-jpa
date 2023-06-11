package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.ConsultaDAO;
import br.com.ifrs.paciente.model.Consulta;


import java.util.Date;

public class TesteConsulta {
    public static void main(String[] args) {
        Consulta consulta = new Consulta(new Date(),new Date(),null,null);

        new ConsultaDAO().salvar(consulta);
    }
}
