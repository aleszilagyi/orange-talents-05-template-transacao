package com.orangetalents.transacao.transacoes.consulta;

import com.orangetalents.transacao.transacoes.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private BigDecimal valor;
    private String nomeEstabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoDto(Transacao transacao) {
        this.valor = transacao.getValor();
        this.nomeEstabelecimento = transacao.getEstabelecimento().getNome();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
