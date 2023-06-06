package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, List<Telefone> telefones) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}


