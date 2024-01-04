package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoPorMarcaListResponse {

    private UUID idProduto;
    private String descricao;
    private String marca;
    private String codigoDeBarra;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public ProdutoPorMarcaListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.codigoDeBarra = produto.getCodigoDeBarra();
        this.valor = produto.getValor();
        this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
    }
    public static List<ProdutoPorMarcaListResponse> converte(List<Produto> produtosPorMarcaList) {
        return produtosPorMarcaList.stream()
                .map(ProdutoPorMarcaListResponse::new)
                .collect(Collectors.toList());
    }
}
