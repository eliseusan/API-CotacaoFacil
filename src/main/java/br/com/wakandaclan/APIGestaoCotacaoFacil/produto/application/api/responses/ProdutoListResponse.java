package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoListResponse {
    private UUID idProduto;
    private UUID idFornecedorProduto;
    private String nomeFantasia;
    private String razaoSocial;
    private String descricao;
    private String marca;
    private String codigoDeBarra;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public ProdutoListResponse(Produto produto, Fornecedor fornecedor) {
        this.idProduto = produto.getIdProduto();
        this.idFornecedorProduto = produto.getIdFornecedorProduto();
        this.nomeFantasia = fornecedor.getNomeFantasia();
        this.razaoSocial = fornecedor.getRazaoSocial();
        this.descricao = produto.getDescricao();
        this.marca = produto.getMarca();
        this.codigoDeBarra = produto.getCodigoDeBarra();
        this.valor = produto.getValor();
        this.dataHoraDoCadastro = produto.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = produto.getDataHoraDaUltimaAlteracao();
    }


    public static List<ProdutoListResponse> converte(List<Produto> produtos, List<Fornecedor> fornecedor) {
        List<ProdutoListResponse> listaProdutoDoFornecedor = new ArrayList<>();
        produtos.stream().forEach(produto -> {
            Optional<Fornecedor> fornecedorDoProduto = fornecedor.stream()
                    .filter(fornecedores -> fornecedores.getIdFornecedor().equals(produto.getIdFornecedorProduto()))
                    .findFirst();
            if (fornecedorDoProduto.isPresent()){
                listaProdutoDoFornecedor.add(new ProdutoListResponse(produto, fornecedorDoProduto.get()));
        }
    });
        return listaProdutoDoFornecedor;
}
}



