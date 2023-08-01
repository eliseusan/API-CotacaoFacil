package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Builder
@Value
public class ProdutoResponse {
    private UUID idProduto ;
}
