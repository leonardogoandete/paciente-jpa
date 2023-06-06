package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Prontuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    private String descricao;

    // Construtor vazio
    public Prontuario() {}

    // Construtor com parâmetros
    public Prontuario(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
