package br.com.ifrs.paciente.model;

import java.io.Serializable;

public enum Situacao implements Serializable {
    NORMAL(1, "Normal"),
    EM_OBSER(2, "Em observacao"),
    HOSP(3, "Hospitalizado");

    private static final long serialVersionUID = 1L;
    private int id;
    private String descricao;

    Situacao(){}
    Situacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
