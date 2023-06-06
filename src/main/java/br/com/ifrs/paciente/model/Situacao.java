package br.com.ifrs.paciente.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Entity
public enum Situacao implements Serializable {
    NORMAL(1, "Normal"),
    EM_OBSER(2, "Em observacao"),
    HOSP(3, "Hospitalizado");

    private static final long serialVersionUID = 1L;
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
