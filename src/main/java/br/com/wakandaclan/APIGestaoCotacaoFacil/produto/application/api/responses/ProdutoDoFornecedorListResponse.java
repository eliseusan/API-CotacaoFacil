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
public class ProdutoDoFornecedorListResponse {
    private UUID idProduto;
    private String descricao;
    private String marca;
    private String codigoDeBarra;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public ProdutoDoFornecedorListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.codigoDeBarra = produto.getCodigoDeBarra();
        this.valor = produto.getValor();
        this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
    }

    public static List<ProdutoDoFornecedorListResponse> converte(List<Produto> produtosFornecedor) {
        return produtosFornecedor.stream()
                .map(ProdutoDoFornecedorListResponse::new)
                .collect(Collectors.toList());
    }
}
