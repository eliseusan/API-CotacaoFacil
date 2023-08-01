package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ProdutoRequest {
    @NotBlank
    private String descricao ;
    @NotBlank
    private String marca ;
    @NotNull
    private String codigoDeBarra;
    @NotNull
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
}
