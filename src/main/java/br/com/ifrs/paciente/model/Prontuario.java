package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Prontuario implements Serializable {
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

    private String descricao;

    public Prontuario() {}

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

    @Override
    public String toString() {
        return "\nID: "+id +"\ndata: " + (data.getDate()+"/"+(data.getMonth()+1)+"/"+(data.getYear()+1900)) + "\ndescricao: " + descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, descricao);
    }
}
