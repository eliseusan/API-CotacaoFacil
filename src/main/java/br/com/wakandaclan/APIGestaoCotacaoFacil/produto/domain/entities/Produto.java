package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities;

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
    @NotBlank
    private String descricao ;
    @NotBlank
    private String marca ;
    @NotNull
    private Integer codigoDeBarra;
    @NotNull
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

}
