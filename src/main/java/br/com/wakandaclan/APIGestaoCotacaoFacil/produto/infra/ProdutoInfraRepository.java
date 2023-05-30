package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository.ProdutoRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
	private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;
	@Override
	public Produto salvaProduto(Produto produto) {
		log.info("[start] ProdutoInfraRepository - salvaProduto ");
		produtoSpringDataJPARepository.save(produto);
		log.info("[finish] ProdutoInfraRepository - salvaProduto ");
		return produto;
	}
}
