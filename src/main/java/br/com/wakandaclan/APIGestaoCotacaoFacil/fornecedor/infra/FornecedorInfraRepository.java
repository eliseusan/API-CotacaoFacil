package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class FornecedorInfraRepository implements FornecedorRepository {
    private final FornecedorSpringDataJPARepository fornecedorSpringDataJPARepository;

    @Override
    public Fornecedor salva(Fornecedor fornecedor) {
        log.info("[start] FornecedorInfraRepository - salvaFornecedor ");
        fornecedorSpringDataJPARepository.save(fornecedor);
        log.info("[finish] FornecedorInfraRepository - salvaFornecedor ");
        return fornecedor;
    }
}
