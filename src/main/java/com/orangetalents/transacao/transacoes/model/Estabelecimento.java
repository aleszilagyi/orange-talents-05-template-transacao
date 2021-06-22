package com.orangetalents.transacao.transacoes.model;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {
    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
}