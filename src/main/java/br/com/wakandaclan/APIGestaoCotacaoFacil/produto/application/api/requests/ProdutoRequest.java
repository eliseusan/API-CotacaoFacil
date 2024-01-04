package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class ProdutoRequest {
    @NotBlank
    private String descricao ;
    @NotBlank
    private String marca ;
    @NotNull
    private String codigoDeBarra;
    @NotNull
    private BigDecimal valor;
}
