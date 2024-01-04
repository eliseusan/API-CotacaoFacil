package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.*;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository.ProdutoRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final FornecedorRepository fornecedorRepository ;

    @Override
    public ProdutoResponse criaProduto(UUID idFornecedorProduto,ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - criaProduto");
        fornecedorRepository.buscaFornecedorPorId(idFornecedorProduto);
        Produto produto = produtoRepository.salvaProduto(new Produto(idFornecedorProduto,produtoRequest));
        log.info("[finish] ProdutoApplicationService - criaProduto");
        return new ProdutoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProdutos() {
        log.info("[start] ProdutoApplicationService - buscaTodosProdutos");
        List<Produto> produtos = produtoRepository.buscaTodosProdutos();
        List<Fornecedor> fornecedor = fornecedorRepository.buscaTodosFornecedores();
        log.info("[finish] ProdutoApplicationService - buscaTodosProdutos");
        return ProdutoListResponse.converte(produtos,fornecedor);
    }

    @Override
    public ProdutoDetalhadoListResponse buscaProdutoPorId(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - buscaProdutoPorId");
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        log.info("[finish] ProdutoApplicationService - buscaProdutoPorId");
        return new ProdutoDetalhadoListResponse(produto);
    }

    @Override
    public void deletaProdutoPorId(UUID idProduto) {
        log.info("[start] ProdutoApplicationService - deletaProdutoPorId");
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        produtoRepository.deletaProdutoPorId(produto);
        log.info("[finish] ProdutoApplicationService - deletaProdutoPorId");
    }

    @Override
    public void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutoApplicationService - alteraProduto");
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        produto.alteraProduto(produtoAlteracaoRequest);
        produtoRepository.salvaProduto(produto);
        log.info("[finish] ProdutoApplicationService - alteraProduto");
    }

    @Override
    public List<ProdutoDoFornecedorListResponse> buscaProdutoPorIdFornecedor(UUID idFornecedorProduto) {
        log.info("[start] ProdutoApplicationService - buscaProdutoPorIdFornecedor");
        fornecedorRepository.buscaFornecedorPorId(idFornecedorProduto);
        List<Produto> produtosFornecedor = produtoRepository.buscaProdutoPorIdFornecedor(idFornecedorProduto);
        log.info("[finish] ProdutoApplicationService - buscaProdutoPorIdFornecedor");
        return ProdutoDoFornecedorListResponse.converte(produtosFornecedor);
    }

    @Override
    public List<ProdutoPorMarcaListResponse> buscaProdutosPorMarca(String marca) {
        log.info("[start] ProdutoApplicationService - buscaProdutosPorMarca");
        List<Produto> produtosPorMarcaList = produtoRepository.buscaProdutosPorMarca(marca);
        log.info("[finish] ProdutoApplicationService - buscaProdutosPorMarca");
        return ProdutoPorMarcaListResponse.converte(produtosPorMarcaList);
    }
}
