package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/fornecedor")

public interface FornecedorAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FornecedorResponse salvaFornecedor(@Valid @RequestBody FornecedorRequest fornecedorRequest);
}
