package br.com.ifrs.model;

import java.util.Date;

public class Prontuario {
    private Date data;
    private String descricao;

    public Prontuario(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Prontuário:\n" +
                "Data: " + data + "\n" +
                "Descrição: " + descricao;
    }
}
