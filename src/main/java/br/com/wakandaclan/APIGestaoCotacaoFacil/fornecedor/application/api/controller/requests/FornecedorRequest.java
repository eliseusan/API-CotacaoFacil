package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests;

import lombok.Getter;
import lombok.ToString;
import java.util.UUID;

@Getter
@ToString
public class FornecedorRequest {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
}
