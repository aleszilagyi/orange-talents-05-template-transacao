package com.orangetalents.transacao.transacoes.listener.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.orangetalents.transacao.transacoes.model.Cartao;
import com.orangetalents.transacao.transacoes.model.Estabelecimento;
import com.orangetalents.transacao.transacoes.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EventoDeTransacaoDto {

    private UUID id;
    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacaoDto() {
    }

    public EventoDeTransacaoDto(UUID id, BigDecimal valor, EstabelecimentoDto estabelecimento, CartaoDto cartao) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Cartao toModel() {
        Set<Transacao> transacaoModel = new HashSet<>();
        Estabelecimento estabelecimentoModel = new Estabelecimento(estabelecimento.getNome(), estabelecimento.getCidade(), estabelecimento.getEndereco());
        Cartao cartaoModel = new Cartao(cartao.getId(), cartao.getEmail());

        transacaoModel.add(new Transacao(id, valor, estabelecimentoModel, cartaoModel, efetivadaEm));
        cartaoModel.addTransacao(transacaoModel);

        return cartaoModel;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}