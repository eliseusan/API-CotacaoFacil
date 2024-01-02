package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
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
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idFornecedor;
    @NotBlank
    private String nomeFantasia;
    @NotBlank
    private String razaoSocial;
    @CNPJ(message = "Insira um CNPJ valido")
    private String cnpj;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Fornecedor(FornecedorRequest novoFornecedorRequest) {
        this.nomeFantasia = novoFornecedorRequest.getNomeFantasia();
        this.razaoSocial = novoFornecedorRequest.getRazaoSocial();
        this.cnpj = novoFornecedorRequest.getCnpj();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}