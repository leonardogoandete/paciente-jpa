package br.com.ifrs.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;

    // Mapeamento bidirecional com a classe Telefone
//    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Telefone> telefones = new ArrayList<>();
    public Pessoa(){}
    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        //this.telefones = new ArrayList<>();
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

//    public List<Telefone> getTelefones() {
//        return telefones;
//    }
//
//    public void adicionarTelefone(Telefone telefone) {
//        telefones.add(telefone);
//    }
//
//    public void removerTelefone(Telefone telefone) {
//        telefones.remove(telefone);
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ").append(nome).append("\n");
        builder.append("Endereço: ").append(endereco).append("\n");
        builder.append("Telefones: ").append("\n");
//        for (Telefone telefone : telefones) {
//            builder.append(telefone).append("\n");
//        }
        return builder.toString();
    }
}
