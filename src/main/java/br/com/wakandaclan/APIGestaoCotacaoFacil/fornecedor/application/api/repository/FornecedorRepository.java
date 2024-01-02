package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;

import java.util.List;
import java.util.UUID;

public interface FornecedorRepository {
    Fornecedor salva(Fornecedor fornecedor);
    List<Fornecedor> buscaTodosFornecedores();

    Fornecedor buscaFornecedorPorId(UUID idFornecedor);
}
