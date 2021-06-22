package com.orangetalents.transacao.transacoes.listener.dto;

public class EstabelecimentoDto {
    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoDto() {
    }

    public EstabelecimentoDto(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
