package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.*;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponse criaProduto(UUID idFornecedorProduto,ProdutoRequest produtoRequest);

    List<ProdutoListResponse> buscaTodosProdutos();

    ProdutoDetalhadoListResponse buscaProdutoPorId(UUID idProduto);

    void deletaProdutoPorId(UUID idProduto);

    void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest);

    List<ProdutoDoFornecedorListResponse> buscaProdutoPorIdFornecedor(UUID idFornecedorProduto);

    List<ProdutoPorMarcaListResponse> buscaProdutosPorMarca(String marca);
}
