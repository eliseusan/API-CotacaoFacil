package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;
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
    public ProdutoResponse salvaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - postProduto");
        var produto = produtoService.criaProduto(produtoRequest);
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
        var produtoPorId = produtoService.buscaProdutoPorId(idProduto);
        log.info("[finish] ProdutoController - buscaProdutoPorId");
        return produtoPorId;
    }
}
