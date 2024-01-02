package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;

public interface FornecedorRepository {
    Fornecedor salva(Fornecedor fornecedor);
}
