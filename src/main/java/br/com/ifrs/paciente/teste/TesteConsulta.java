package br.com.ifrs.paciente.teste;

import br.com.ifrs.paciente.dao.ConsultaDAO;
import br.com.ifrs.paciente.model.Consulta;
import java.util.Date;

public class TesteConsulta {
    public static void main(String[] args) {
//        Consulta consulta = new Consulta(new Date(),new Date(),null,null);
//        new ConsultaDAO().salvar(consulta);
//        Consulta consulta = new ConsultaDAO().buscarPorId(2l);
//        System.out.println(consulta);
//        Consulta consulta1 = new Consulta();
//        //System.out.println(new ConsultaDAO().listarTodos());
//        new ConsultaDAO().salvar(new Consulta(new Date(),new Date(), null,null));

        for (Consulta c: new ConsultaDAO().listarTodos()) {
            System.out.println(c.toString());
        }
    }
}
