package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse salvaProduto(@Valid @RequestBody ProdutoRequest produtoRequest);
}
