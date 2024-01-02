package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@ToString
public class FornecedorResponse {
    private UUID idFornecedor;
    private String nomeFantasia;

    public FornecedorResponse(Fornecedor fornecedor) {
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.nomeFantasia = fornecedor.getNomeFantasia();
    }
}
