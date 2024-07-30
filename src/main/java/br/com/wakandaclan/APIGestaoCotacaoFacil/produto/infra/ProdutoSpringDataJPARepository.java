package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoSpringDataJPARepository extends JpaRepository<Produto, UUID> {

    List<Produto> findByIdFornecedorProduto(UUID idFornecedorProduto);

    List<Produto> findByMarcaLikeOrderByValorAsc(String marca);

    // Busca o produto com o menor preço para uma dada descrição e marca
    @Query("SELECT p FROM Produto p WHERE p.descricao = :descricao AND p.marca = :marca ORDER BY p.valor ASC")
    List<Produto> findFirstProdutoByDescricaoAndMarcaOrderByValorAsc(@Param("descricao") String descricao, @Param("marca") String marca);

}

