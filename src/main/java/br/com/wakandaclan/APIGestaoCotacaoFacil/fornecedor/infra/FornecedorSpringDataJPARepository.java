package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.infra;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface FornecedorSpringDataJPARepository extends JpaRepository<Fornecedor, UUID> {
}
