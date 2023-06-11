package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Paciente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String convenio;

    private String cpf;

    /*
        Estou utilizando a biblioteca do java.util.Date, escolhi por vir padrão no Java,
        apesar de algumas limitações e respeitando o diagrama de classes.
        Para esse tipo de bliblioteca é necessário informar que é do tipo temporal para o JPA e especificar a
        ENUM do tipo DATE para guardar somente a data dd/mm/aaaa no banco.
        */
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> emails = new ArrayList<>();

    /*
        Utilizei a estratégia do tipo EnumType.String, escolhi salvar o valor em vez do ID da enum.
        */
    @OneToOne
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "paciente", cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return  super.toString()+
                "\nconvenio=" + convenio +
                "\ncpf=" + cpf +
                "\nData Nascimento=" + dataNascimento +
                "\nemails=" + emails +
                "\nsituacao=" + situacao +
                "\nconsultas=" + consultas +
                "\nprontuario=" + prontuario + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(convenio, paciente.convenio) && Objects.equals(cpf, paciente.cpf) && Objects.equals(dataNascimento, paciente.dataNascimento) && Objects.equals(emails, paciente.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, convenio, cpf, dataNascimento, emails);
    }
}

