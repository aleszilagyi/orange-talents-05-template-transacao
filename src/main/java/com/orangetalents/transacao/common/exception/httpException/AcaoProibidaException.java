package com.orangetalents.transacao.common.exception.httpException;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AcaoProibidaException extends ResponseStatusException {
    public AcaoProibidaException() {
        super(HttpStatus.FORBIDDEN, "Ação não autorizada");
    }

    public AcaoProibidaException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
