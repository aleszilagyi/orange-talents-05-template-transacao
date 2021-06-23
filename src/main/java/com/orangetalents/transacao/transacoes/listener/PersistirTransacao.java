package com.orangetalents.transacao.transacoes.listener;

import com.orangetalents.transacao.common.exception.kafkaException.KafkaEntidadeJaExisteException;
import com.orangetalents.transacao.transacoes.consulta.TransacaoRepository;
import com.orangetalents.transacao.transacoes.listener.dto.EventoDeTransacaoDto;
import com.orangetalents.transacao.transacoes.model.Cartao;
import com.orangetalents.transacao.transacoes.model.Transacao;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PersistirTransacao implements ConstraintValidator<PersisteTransacao, EventoDeTransacaoDto> {
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;
    private final Logger logger = LoggerFactory.getLogger(PersistirTransacao.class);

    @Override
    @Modifying
    @Transactional
    public boolean isValid(EventoDeTransacaoDto eventoDeTransacaoDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Cartao cartao = eventoDeTransacaoDto.toModel();
            Optional<Transacao> transacao = transacaoRepository.findByIdAndCartaoId(eventoDeTransacaoDto.getId(), cartao.getId());
            transacao.ifPresent((c) -> {
                throw new KafkaEntidadeJaExisteException(c.getId().toString());
            });

            Optional<Cartao> cartaoRegistrado = cartaoRepository.findById(cartao.getId());
            cartaoRegistrado.ifPresentOrElse(c -> c.addTransacao(cartao.getTransacoes()), () -> cartaoRepository.save(cartao));

            return true;
        } catch (KafkaException e) {
            logger.warn(e.getMessage());
            return true;
        }
    }
}
