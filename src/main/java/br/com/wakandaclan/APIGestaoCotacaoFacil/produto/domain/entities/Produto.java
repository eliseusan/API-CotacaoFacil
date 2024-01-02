package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "produtos")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idProduto", updatable = false, unique = true, nullable = false)
    private UUID idProduto ;
    @NotNull
    @Column(columnDefinition = "uuid", name = "idFornecedorProduto", nullable = false)
    private UUID idFornecedorProduto ;
    @NotBlank
    private String descricao ;
    @NotBlank
    private String marca ;
    @NotNull
    private String codigoDeBarra;
    @NotNull
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public Produto(UUID idFornecedorProduto,ProdutoRequest produtoRequest) {
        this.idFornecedorProduto = idFornecedorProduto;
        this.descricao = produtoRequest.getDescricao();
        this.marca = produtoRequest.getMarca();
        this.codigoDeBarra = produtoRequest.getCodigoDeBarra();
        this.valor = produtoRequest.getValor();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void alteraProduto(ProdutoAlteracaoRequest produtoAlteracaoRequest) {
        this.descricao = produtoAlteracaoRequest.getDescricao();
        this.marca = produtoAlteracaoRequest.getMarca();
        this.codigoDeBarra = produtoAlteracaoRequest.getCodigoDeBarra();
        this.valor = produtoAlteracaoRequest.getValor();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
