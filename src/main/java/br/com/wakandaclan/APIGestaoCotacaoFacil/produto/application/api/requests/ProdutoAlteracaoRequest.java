package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class ProdutoAlteracaoRequest {
    private String descricao;
    @NotBlank
    private String marca;
    @NotNull
    private String codigoDeBarra;
    @NotNull
    private BigDecimal valor;
}
