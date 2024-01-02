package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;

public interface FornecedorService {
    FornecedorResponse criaFornecedor(FornecedorRequest fornecedorRequest);
}
