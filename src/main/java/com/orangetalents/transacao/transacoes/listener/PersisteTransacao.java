package com.orangetalents.transacao.transacoes.listener;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {PersistirTransacao.class})
@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PersisteTransacao {
    String message() default "Proposta fornecida não existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
