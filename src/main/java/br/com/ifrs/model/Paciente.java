package br.com.ifrs.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Paciente extends Pessoa {
    private String convenio;
    private String cpf;
    private Date dataNascimento;
    private List<String> emails;
    private Situacao situacao;
    private List<Consulta> consultas;
    private List<Medico> medicos;

    public Paciente(String nome, String endereco, String convenio, String cpf, Date dataNascimento) {
        super(nome, endereco);
        this.convenio = convenio;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.emails = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.medicos = new ArrayList<>();
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void adicionarEmail(String email) {
        emails.add(email);
    }

    public void removerEmail(String email) {
        emails.remove(email);
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void removerConsulta(Consulta consulta) {
        consultas.remove(consulta);
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void removerMedico(Medico medico) {
        medicos.remove(medico);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("Convenio: ").append(convenio).append("\n");
        builder.append("CPF: ").append(cpf).append("\n");
        builder.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        builder.append("Emails: ").append("\n");
        for (String email : emails) {
            builder.append(email).append("\n");
        }
        builder.append("Situação: ").append(situacao).append("\n");
        builder.append("Consultas: ").append("\n");
        for (Consulta consulta : consultas) {
            builder.append(consulta).append("\n");
        }
        builder.append("Médicos: ").append("\n");
        for (Medico medico : medicos) {
            builder.append(medico).append("\n");
        }
        return builder.toString();
    }
}
