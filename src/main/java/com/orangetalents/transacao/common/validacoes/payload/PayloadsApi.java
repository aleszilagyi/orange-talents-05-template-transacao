package com.orangetalents.transacao.common.validacoes.payload;

import org.springframework.http.HttpStatus;

import javax.validation.Payload;

public interface PayloadsApi extends Payload {
    HttpStatus getStatus();
}
