package br.com.ifrs.paciente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
/*
    Utilizei a estrategia de mapeamento com os dados em uma unica tabela, por ser mais rápido e simples,
    Posso filtrar o tipo da herança utilizando uma coluna onde guardo o tipo da classe na linha
    da tabela(DTYPE). Mesmo com o risco de valores pondendo ser nulo.
    */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("###########= PACIENTE =###########");
        sb.append("\nID:").append(id);
        sb.append("\nNome:").append(nome);
        sb.append("\nEndereco:").append(endereco);
        sb.append("\nTelefones:");
        if (telefones != null && !telefones.isEmpty()) {
            for (Telefone telefone : telefones) {
                sb.append("("+telefone.getDdd()+")").append(telefone.getNumero()+",");
            }
        } else {
            sb.append("Nenhum telefone registrado");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(telefones, pessoa.telefones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, telefones);
    }
}


