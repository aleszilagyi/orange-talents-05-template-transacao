package com.orangetalents.transacao.transacoes;

import com.orangetalents.transacao.transacoes.dto.EventoDeTransacaoDto;
import com.orangetalents.transacao.transacoes.model.Transacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(@PersisteTransacao EventoDeTransacaoDto eventoDeTransacaoDto) {
    }
}
