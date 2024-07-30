package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoCotacaoPorMarcaListResponse {
    private UUID idProduto;

    private String descricao;

    private String marca;

    private String codigoDeBarra;

    private BigDecimal valor;

    public ProdutoCotacaoPorMarcaListResponse(Produto produtos) {
        this.descricao = produtos.getDescricao();
        this.marca = produtos.getMarca();
        this.codigoDeBarra = produtos.getCodigoDeBarra();
        this.valor = produtos.getValor();
    }

    public static List<ProdutoCotacaoPorMarcaListResponse> converte(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoCotacaoPorMarcaListResponse::new)
                .collect(Collectors.toList());

    }
}
