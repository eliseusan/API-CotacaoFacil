package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.handler.APIException;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository.ProdutoRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
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

	@Override
	public List<Produto> buscaTodosProdutos() {
		log.info("[start] ProdutoInfraRepository - buscaTodosProdutos ");
		var produtos = produtoSpringDataJPARepository.findAll();
		log.info("[finish] ProdutoInfraRepository - buscaTodosProdutos ");
		return produtos;
	}

	@Override
	public Produto buscaProdutoPorId(UUID idProduto) {
		log.info("[start] ProdutoInfraRepository - buscaProdutoPorId ");
		var produtoPorId = produtoSpringDataJPARepository.findById(idProduto)
				.orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "PRODUTO NÃO ENCONTRADO!"));
		log.info("[finish] ProdutoInfraRepository - buscaProdutoPorId ");
		return produtoPorId;
	}

	@Override
	public void deletaProdutoPorId(Produto produto) {
		log.info("[start] ProdutoInfraRepository - deletaProdutoPorId ");
		produtoSpringDataJPARepository.delete(produto);
		log.info("[finish] ProdutoInfraRepository - deletaProdutoPorId ");
	}

	@Override
	public List<Produto> buscaProdutoPorIdFornecedor(UUID idFornecedorProduto) {
		log.info("[start] ProdutoInfraRepository - buscaProdutoPorIdFornecedor ");
		var produtos = produtoSpringDataJPARepository.findByIdFornecedorProduto(idFornecedorProduto);
		log.info("[finish] ProdutoInfraRepository - buscaProdutoPorIdFornecedor ");
		return produtos;
	}

	@Override
	public List<Produto> buscaProdutosPorMarca(String marca) {
		log.info("[start] ProdutoInfraRepository - buscaProdutoPorIdFornecedor ");

		// Adicione o caractere "%" à marca para buscar tudo depois do primeiro caractere
		String marcaComWildcard = marca + "%";

		List<Produto> produtos = produtoSpringDataJPARepository.findByMarcaLike(marcaComWildcard);

		if (produtos.isEmpty()) {
			log.warn("Nenhum produto encontrado para a marca começando com: {}", marca);
			throw APIException.build(HttpStatus.BAD_REQUEST, "PRODUTO NÃO ENCONTRADO!");
		}

		log.info("[finish] ProdutoInfraRepository - buscaProdutoPorIdFornecedor ");
		return produtos;
	}


}
