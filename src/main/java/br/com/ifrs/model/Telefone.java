package br.com.ifrs.model;

import javax.persistence.*;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ddd;
    private String numero;

    // Mapeamento bidirecional com a classe Pessoa
    @ManyToOne
    private Pessoa pessoa;
    public Telefone(int ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "(" + ddd + ") " + numero;
    }
}
