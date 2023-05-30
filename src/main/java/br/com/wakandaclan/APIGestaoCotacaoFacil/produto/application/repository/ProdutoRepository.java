package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);
}
