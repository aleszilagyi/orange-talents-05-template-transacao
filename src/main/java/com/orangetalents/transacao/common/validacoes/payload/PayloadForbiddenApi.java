package com.orangetalents.transacao.common.validacoes.payload;

import org.springframework.http.HttpStatus;

public class PayloadForbiddenApi implements PayloadsApi {
    private HttpStatus status = HttpStatus.FORBIDDEN;

    public PayloadForbiddenApi() {
    }

    public HttpStatus getStatus() {
        return status;
    }
}
