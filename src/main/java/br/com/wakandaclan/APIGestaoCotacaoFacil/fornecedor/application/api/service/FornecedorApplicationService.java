package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FornecedorApplicationService implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Override
    public FornecedorResponse criaFornecedor(FornecedorRequest novoFornecedorRequest) {
        log.info("[start] FornecedorApplicationService - criaFornecedor");
        Fornecedor fornecedor = fornecedorRepository.salva(new Fornecedor(novoFornecedorRequest));
        log.info("[finish] FornecedorApplicationService - criaFornecedor");
        return new FornecedorResponse(fornecedor);
    }

    @Override
    public List<FornecedorListResponse> buscaTodosFornecedores() {
        log.info("[start] FornecedorApplicationService - buscaTodosFornecedores");
        List<Fornecedor> fornecedor = fornecedorRepository.buscaTodosFornecedores();
        log.info("[finish] FornecedorApplicationService - buscaTodosFornecedores");
        return FornecedorListResponse.converte(fornecedor);
    }

    @Override
    public FornecedorDetalhadoListResponse buscaFornecedorPorId(UUID idFornecedor) {
        log.info("[start] FornecedorApplicationService - buscaFornecedorPorId");
        Fornecedor fornecedor = fornecedorRepository.buscaFornecedorPorId(idFornecedor);
        log.info("[finish] FornecedorApplicationService - buscaFornecedorPorId");
        return new FornecedorDetalhadoListResponse(fornecedor);
    }

    @Override
    public void alteraFornecedor(UUID idFornecedor, FornecedorAlteracaoRequest fornecedorAlteracaoRequest) {
        log.info("[start] FornecedorApplicationService - alteraFornecedor");
        Fornecedor fornecedor = fornecedorRepository.buscaFornecedorPorId(idFornecedor);
        fornecedor.alteraFornecedor(fornecedorAlteracaoRequest);
        fornecedorRepository.salva(fornecedor);
        log.info("[finish] FornecedorApplicationService - alteraFornecedor");
    }

    @Override
    public void deletaFornecedorPorId(UUID idFornecedor) {
        log.info("[start] FornecedorApplicationService - deletaFornecedorPorId");
        Fornecedor fornecedor = fornecedorRepository.buscaFornecedorPorId(idFornecedor);
        fornecedorRepository.deletaFornecedorPorId(fornecedor);
        log.info("[finish] FornecedorApplicationService - deletaFornecedorPorId");
    }
}
