package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ProdutoListResponse {
    private UUID idProduto ;
    private String descricao ;
    private String marca ;
    private String codigoDeBarra;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.codigoDeBarra = produto.getCodigoDeBarra();
        this.valor = produto.getValor();
        this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
    }

    public static List<ProdutoListResponse> converte(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoListResponse::new)
                .collect(Collectors.toList());
    }
}
