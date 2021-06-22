package com.orangetalents.transacao.transacoes.listener;

import com.orangetalents.transacao.transacoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
}
