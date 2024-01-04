package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests;

import lombok.*;

@Getter
@ToString
@Builder
public class FornecedorRequest {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;


}
