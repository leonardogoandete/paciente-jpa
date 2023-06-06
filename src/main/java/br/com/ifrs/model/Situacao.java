package br.com.ifrs.model;

public enum Situacao {
    NORMAL(1, "Normal"),
    EM_OBSERVACAO(2, "Em Observação"),
    HOSPITALIZADO(3, "Hospitalizado");

    private int id;
    private String descricao;

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
