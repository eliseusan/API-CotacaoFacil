package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDetalhadoListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/fornecedor")

public interface FornecedorAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    FornecedorResponse salvaFornecedor(@Valid @RequestBody FornecedorRequest fornecedorRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<FornecedorListResponse> buscaTodosFornecedores();

    @GetMapping(value = "/{idFornecedor}")
    @ResponseStatus(code = HttpStatus.OK)
    FornecedorDetalhadoListResponse buscaFornecedorPorId(@PathVariable UUID idFornecedor);

    @PatchMapping(value = "/{idFornecedor}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraFornecedor(@PathVariable UUID idFornecedor,
                       @Valid @RequestBody FornecedorAlteracaoRequest fornecedorAlteracaoRequest);
}
