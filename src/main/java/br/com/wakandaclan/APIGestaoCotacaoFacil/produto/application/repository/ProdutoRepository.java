package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salvaProduto(Produto produto);

    List<Produto> buscaTodosProdutos();

    Produto buscaProdutoPorId(UUID idProduto);

    void deletaProdutoPorId(Produto produto);

    List<Produto> buscaProdutoPorIdFornecedor(UUID idFornecedorProduto);
}
