package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/produto")
public interface ProdutoAPI {

    @PostMapping(value = "/{idFornecedorProduto}")
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse salvaProduto(@Valid @PathVariable UUID idFornecedorProduto, @RequestBody ProdutoRequest produtoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> buscaTodosProdutos();

    @GetMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoListResponse buscaProdutoPorId(@PathVariable UUID idProduto);

    @GetMapping(value = "/{idFornecedorProduto}/fornecedor")
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoDoFornecedorListResponse> findAllProdutosPorIdFornecedorProduto(@PathVariable UUID idFornecedorProduto);

    @DeleteMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaProdutoPorId(@PathVariable UUID idProduto);

    @PatchMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraProduto(@PathVariable UUID idProduto,
                       @Valid @RequestBody ProdutoAlteracaoRequest produtoAlteracaoRequest);

    @GetMapping(value = "marca/{marca}")
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoPorMarcaListResponse> findAllProdutosPorMarca(@PathVariable String marca);
}
