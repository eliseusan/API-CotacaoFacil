package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FornecedorController implements FornecedorAPI{
    private final FornecedorService fornecedorService;
    @Override
    public FornecedorResponse salvaFornecedor(FornecedorRequest fornecedorRequest) {
        log.info("[start] FornecedorController - salvaFornecedor");
        var fornecedor = fornecedorService.criaFornecedor(fornecedorRequest);
        log.info("[finish] FornecedorController - salvaFornecedor");
        return fornecedor;
    }

    @Override
    public List<FornecedorListResponse> buscaTodosFornecedores() {
        log.info("[start] FornecedorController - buscaTodosProdutos");
        var listaDeProdutos = fornecedorService.buscaTodosFornecedores();
        log.info("[finish] FornecedorController - buscaTodosProdutos");
        return listaDeProdutos;
    }

    @Override
    public FornecedorDetalhadoListResponse buscaFornecedorPorId(UUID idFornecedor) {
        log.info("[start] FornecedorController - buscaFornecedorPorId");
        log.info("[idFornecedor] {}", idFornecedor);
        var fornecedorPorId = fornecedorService.buscaFornecedorPorId(idFornecedor);
        log.info("[finish] FornecedorController - buscaFornecedorPorId");
        return fornecedorPorId;
    }
}
