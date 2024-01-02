package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
