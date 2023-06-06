package br.com.ifrs.model;
import java.util.ArrayList;
import java.util.List;


public class Medico {
    private String crm;
    private String especialidade;
    private List<Consulta> consultas;

    public Medico(String crm, String especialidade) {
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setMedico(this);
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
        consulta.setMedico(null);
    }

    @Override
    public String toString() {
        return "Médico:\n" +
                "  CRM: " + crm + "\n" +
                "  Especialidade: " + especialidade + "\n" +
                "  Consultas: " + consultas.size();
    }
}
