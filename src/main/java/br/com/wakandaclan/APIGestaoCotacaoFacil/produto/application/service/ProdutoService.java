package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponse criaProduto(ProdutoRequest produtoRequest);

    List<ProdutoListResponse> buscaTodosProdutos();

    ProdutoDetalhadoListResponse buscaProdutoPorId(UUID idProduto);
}
