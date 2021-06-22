package com.orangetalents.transacao.transacoes.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table
public class Transacao {
    @Id
    private UUID id;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @ManyToOne
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(UUID id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transacao)) return false;
        Transacao transacao = (Transacao) o;
        return id.equals(transacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}