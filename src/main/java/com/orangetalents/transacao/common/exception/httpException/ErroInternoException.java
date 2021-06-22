package com.orangetalents.transacao.common.exception.httpException;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErroInternoException extends ResponseStatusException {
    public ErroInternoException() {
        super(HttpStatus.BAD_REQUEST, "Desculpe, ocorreu um erro. Tente novamente.");
    }
}
