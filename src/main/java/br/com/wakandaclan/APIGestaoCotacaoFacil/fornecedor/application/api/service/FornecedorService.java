package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;

import java.util.List;
import java.util.UUID;

public interface FornecedorService {
    FornecedorResponse criaFornecedor(FornecedorRequest fornecedorRequest);

    List<FornecedorListResponse> buscaTodosFornecedores();

    FornecedorDetalhadoListResponse buscaFornecedorPorId(UUID idFornecedor);

    void alteraFornecedor(UUID idFornecedor, FornecedorAlteracaoRequest fornecedorAlteracaoRequest);

    void deletaFornecedorPorId(UUID idFornecedor);
}
