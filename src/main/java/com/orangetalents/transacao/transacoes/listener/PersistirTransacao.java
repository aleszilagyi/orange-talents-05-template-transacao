package com.orangetalents.transacao.transacoes.listener;

import com.orangetalents.transacao.transacoes.listener.dto.EventoDeTransacaoDto;
import com.orangetalents.transacao.transacoes.model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PersistirTransacao implements ConstraintValidator<PersisteTransacao, EventoDeTransacaoDto> {
    @Autowired
    private CartaoRepository repository;

    @Override
    @Modifying
    @Transactional
    public boolean isValid(EventoDeTransacaoDto eventoDeTransacaoDto, ConstraintValidatorContext constraintValidatorContext) {
        Cartao cartao = eventoDeTransacaoDto.toModel();
        Optional<Cartao> cartaoRegistrado = repository.findById(cartao.getId());
        cartaoRegistrado.ifPresentOrElse(c -> c.addTransacao(cartao.getTransacoes()), () -> repository.save(cartao));
        return true;
    }
}
