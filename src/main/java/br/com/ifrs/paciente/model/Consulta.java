package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        Estou utilizando a biblioteca do java.util.Date, escolhi por vir padrão no Java,
        apesar de algumas limitações e respeitando o diagrama de classes.
        Para esse tipo de bliblioteca é necessário informar que é do tipo temporal para o JPA e especificar a
        ENUM do tipo DATE para guardar somente a data dd/mm/aaaa no banco.
        */

    @Temporal(TemporalType.DATE)
    private Date data;

    /*
        Estou utilizando a biblioteca do java.util.Date, escolhi por vir padrão no Java,
        apesar de algumas limitações e respeitando o diagrama de classes.
        Para esse tipo de bliblioteca é necessário informar que é do tipo temporal para o JPA e especificar a
        ENUM do tipo TIME para guardar somente a hora no banco.
        */
    @Temporal(TemporalType.TIME)
    private Date horario;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Medico medico;

    public Consulta(){}
    public Consulta(Date data, Date horario, Paciente paciente, Medico medico) {
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return  "\nConsulta ID: "+ id +
                "\nData: " + data.getDate() +"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900) +
                "\nHorario: " + horario.getHours()+":"+horario.getMinutes() +
                "\nPaciente: " + paciente.getNome() +
                "\nMedico: " + medico.getEspecialidade()+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id) && Objects.equals(data, consulta.data) && Objects.equals(horario, consulta.horario) && Objects.equals(paciente, consulta.paciente) && Objects.equals(medico, consulta.medico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, horario, paciente, medico);
    }
}



