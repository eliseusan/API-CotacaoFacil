package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, UUID> {

    List<Produto> findByIdFornecedorProduto(UUID idFornecedorProduto);
}
