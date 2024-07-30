package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.controller;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class ProdutoCotacaoRequest {
    private String descricao;
    private String marca;
    private BigDecimal valor;
}
