package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ProdutoDetalhadoListResponse {
    private UUID idProduto ;
    private String descricao ;
    private String marca ;
    private String codigoDeBarra;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public ProdutoDetalhadoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.codigoDeBarra = produto.getCodigoDeBarra();
        this.valor = produto.getValor();
        this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
    }
}
