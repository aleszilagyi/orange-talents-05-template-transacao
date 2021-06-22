package com.orangetalents.transacao.transacoes.consulta;

import com.orangetalents.transacao.common.validacoes.IsUUID;
import com.orangetalents.transacao.transacoes.model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/transacoes")
@Validated
public class ConsultaController {
    @Autowired
    private TransacaoRepository repository;

    @GetMapping("/{idCartao}")
    public ResponseEntity<Page<TransacaoDto>> consultar(@PathVariable @IsUUID(fieldName = "id", domainClass = Cartao.class) String idCartao,
                                                        @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(repository.findAllByCartaoId(UUID.fromString(idCartao), paginacao).map(TransacaoDto::new));
    }
}
