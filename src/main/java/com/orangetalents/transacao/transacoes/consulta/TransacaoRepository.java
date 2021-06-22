package com.orangetalents.transacao.transacoes.consulta;

import com.orangetalents.transacao.transacoes.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    Page<Transacao> findAllByCartaoId(UUID fromString, Pageable paginacao);
}
