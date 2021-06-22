package com.orangetalents.transacao.common.exception.kafkaException;

import org.apache.kafka.common.KafkaException;

public class KafkaEntidadeJaExisteException extends KafkaException {

    public KafkaEntidadeJaExisteException(String idMessage) {
        super("Já existe este registro " + idMessage + " no banco, rolling back para evitar duplicação");
    }
}
