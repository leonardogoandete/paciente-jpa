package br.com.ifrs.model;

import java.util.Date;

public class Consulta {
    private Date data;
    private Date horario;
    private Paciente paciente;
    private Medico medico;
    private Prontuario prontuario;

    public Consulta(Date data, Date horario, Paciente paciente, Medico medico, Prontuario prontuario) {
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
        this.medico = medico;
        this.prontuario = prontuario;
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

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public String toString() {
        return "Consulta realizada em " + data + " às " + horario + "\n" +
                "Paciente: " + paciente + "\n" +
                "Médico: " + medico + "\n" +
                "Prontuário: " + prontuario;
    }
}
