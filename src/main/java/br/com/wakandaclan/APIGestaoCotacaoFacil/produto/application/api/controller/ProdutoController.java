package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.*;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse salvaProduto(UUID idFornecedorProduto, ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - postProduto");
        log.info("[idFornecedorProduto] {}", idFornecedorProduto);
        var produto = produtoService.criaProduto(idFornecedorProduto, produtoRequest);
        log.info("[finish] ProdutoController - postProduto");
        return produto;
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProdutos() {
        log.info("[start] ProdutoController - buscaTodosProdutos");
        var listaDeProdutos = produtoService.buscaTodosProdutos();
        log.info("[finish] ProdutoController - buscaTodosProdutos");
        return listaDeProdutos;
    }

    @Override
    public ProdutoDetalhadoListResponse buscaProdutoPorId(UUID idProduto) {
        log.info("[start] ProdutoController - buscaProdutoPorId");
        log.info("[idProduto] {}", idProduto);
        var produtoPorId = produtoService.buscaProdutoPorId(idProduto);
        log.info("[finish] ProdutoController - buscaProdutoPorId");
        return produtoPorId;
    }

    @Override
    public List<ProdutoDoFornecedorListResponse> findAllProdutosPorIdFornecedorProduto(UUID idFornecedorProduto) {
        log.info("[start] ProdutoController - findAllProdutosPorIdFornecedorProduto");
        log.info("[idFornecedorProduto] {}", idFornecedorProduto);
        List<ProdutoDoFornecedorListResponse> produtoDoFornecedor = produtoService.buscaProdutoPorIdFornecedor(idFornecedorProduto);
        log.info("[finish] ProdutoController - findAllProdutosPorIdFornecedorProduto");
        return produtoDoFornecedor;
    }

    @Override
    public void deletaProdutoPorId(UUID idProduto) {
        log.info("[start] ProdutoController - deletaProdutoPorId");
        log.info("[idProduto] {}", idProduto);
        produtoService.deletaProdutoPorId(idProduto);
        log.info("[finish] ProdutoController - deletaProdutoPorId");
    }

    @Override
    public void alteraProduto(UUID idProduto, ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        log.info("[start] ProdutoController - alteraProduto");
        log.info("[idProduto] {}", idProduto);
        produtoService.alteraProduto(idProduto, produtoAlteracaoRequest);
        log.info("[finish] ProdutoController - alteraProduto");
    }

    @Override
    public List<ProdutoPorMarcaListResponse> findAllProdutosPorMarca(String marca) {
        log.info("[start] ProdutoController - findAllProdutosPorMarca");
        var listaDeProdutos = produtoService.buscaProdutosPorMarca(marca);
        log.info("[finish] ProdutoController - findAllProdutosPorMarca");
        return listaDeProdutos;
    }
}
