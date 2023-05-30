package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;

import java.util.List;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);

    List<Produto> buscaTodosProdutos();
}
