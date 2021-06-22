package com.orangetalents.transacao.transacoes.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Cartao {
    @Id
    private UUID id;
    private String email;
    @ElementCollection
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL)
    private Set<Transacao> transacoes = new HashSet<>();

    @Deprecated
    public Cartao() {
    }

    public Cartao(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public void addTransacao(Set<Transacao> transacoes) {
        this.transacoes.addAll(transacoes);
    }

    public UUID getId() {
        return id;
    }

    public Set<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cartao)) return false;
        Cartao cartao = (Cartao) o;
        return id.equals(cartao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
