package com.orangetalents.transacao.common.validacoes.payload;

import org.springframework.http.HttpStatus;

public class PayloadUnprocessableEntityApi implements PayloadsApi {
    private HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    public PayloadUnprocessableEntityApi() {
    }

    public HttpStatus getStatus() {
        return status;
    }
}
