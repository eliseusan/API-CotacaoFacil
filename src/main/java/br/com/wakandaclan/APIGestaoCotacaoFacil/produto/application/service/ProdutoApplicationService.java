package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller.ProdutoAPI;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository.ProdutoRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - criaProduto");
        Produto produto = produtoRepository.salvaProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - criaProduto");
        return ProdutoResponse.builder()
                .idProduto(produto.getIdProduto())
                .build();
    }

    @Override
    public List<ProdutoListResponse> buscaTodosProdutos() {
        log.info("[start] ClienteApplicationService - buscaTodosProdutos");
        List<Produto> produtos = produtoRepository.buscaTodosProdutos();
        log.info("[finish] ClienteApplicationService - buscaTodosProdutos");
        return ProdutoListResponse.converte(produtos);
    }
}
