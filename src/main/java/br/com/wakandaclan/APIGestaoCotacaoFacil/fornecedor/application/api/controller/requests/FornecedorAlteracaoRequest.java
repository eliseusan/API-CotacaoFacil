package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@ToString
public class FornecedorAlteracaoRequest {
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private String razaoSocial;
}
