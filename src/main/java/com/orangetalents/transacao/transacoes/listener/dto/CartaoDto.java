package com.orangetalents.transacao.transacoes.listener.dto;

import java.util.UUID;

public class CartaoDto {
    private UUID id;
    private String email;

    @Deprecated
    public CartaoDto() {
    }

    public CartaoDto(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
