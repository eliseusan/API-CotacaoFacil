package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.UUID;
@ToString
@Getter
public class FornecedorDetalhadoListResponse {
    private UUID idFornecedor;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;
    public FornecedorDetalhadoListResponse(Fornecedor fornecedor) {
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.nomeFantasia = fornecedor.getNomeFantasia();
        this.razaoSocial = fornecedor.getRazaoSocial();
        this.cnpj = fornecedor.getCnpj();
        this.dataHoraDoCadastro = fornecedor.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = fornecedor.getDataHoraDaUltimaAlteracao();
    }
}
