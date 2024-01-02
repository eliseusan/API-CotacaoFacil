package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ToString
@Getter
public class FornecedorListResponse {

    private UUID idFornecedor;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public FornecedorListResponse(Fornecedor fornecedor) {
        this.idFornecedor = fornecedor.getIdFornecedor();
        this.nomeFantasia = fornecedor.getNomeFantasia();
        this.razaoSocial = fornecedor.getRazaoSocial();
        this.cnpj = fornecedor.getCnpj();
        this.dataHoraDoCadastro = fornecedor.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = fornecedor.getDataHoraDaUltimaAlteracao();
    }

    public static List<FornecedorListResponse> converte(List<Fornecedor> fornecedor) {
        return fornecedor.stream()
                .map(FornecedorListResponse::new)
                .collect(Collectors.toList());
    }
}
