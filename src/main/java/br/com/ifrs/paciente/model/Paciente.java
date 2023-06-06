package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String convenio;

    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @ElementCollection
    private List<String> emails = new ArrayList<>();

    @OneToOne
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;

    public Paciente(){}

    public Paciente(String nome, String endereco, List<Telefone> telefones, String convenio, String cpf, Date dataNascimento, List<String> emails, Situacao situacao, List<Consulta> consultas, Prontuario prontuario) {
        super(nome, endereco, telefones);
        this.convenio = convenio;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.emails = emails;
        this.situacao = situacao;
        this.consultas = consultas;
        this.prontuario = prontuario;
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

    public void setEmails(List<String> emails) {
        this.emails = emails;
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

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }


}

