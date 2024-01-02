package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDoFornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponse criaProduto(UUID idFornecedorProduto,ProdutoRequest produtoRequest);

    List<ProdutoListResponse> buscaTodosProdutos();

    ProdutoDetalhadoListResponse buscaProdutoPorId(UUID idProduto);

    void deletaProdutoPorId(UUID idProduto);

    void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest);

    List<ProdutoDoFornecedorListResponse> buscaProdutoPorIdFornecedor(UUID idFornecedorProduto);
}
