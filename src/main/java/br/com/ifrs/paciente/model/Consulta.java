package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @Temporal(TemporalType.TIME)
    private Date horario;

    // outras propriedades da consulta

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


}



