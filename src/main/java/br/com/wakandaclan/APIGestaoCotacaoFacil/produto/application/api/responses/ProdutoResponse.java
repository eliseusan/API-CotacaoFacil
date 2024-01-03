package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;
@Getter
@ToString
public class ProdutoResponse {
    private UUID idProduto ;

    public ProdutoResponse(Produto produto) {
        this.idProduto= produto.getIdProduto();
    }
}
