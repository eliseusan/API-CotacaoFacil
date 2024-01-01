package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "produtos")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idFornecedor", updatable = false, unique = true, nullable = false)
    private UUID idFornecedor;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private String razaoSocial;
    @CNPJ(message = "Insira um CNPJ valido")
    private String cnpj;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;
}