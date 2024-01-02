package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.infra;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Fornecedor> buscaTodosFornecedores() {
        log.info("[start] FornecedorInfraRepository - buscaTodosFornecedores ");
        var fornecedores =  fornecedorSpringDataJPARepository.findAll();
        log.info("[finish] FornecedorInfraRepository - buscaTodosFornecedores ");
        return fornecedores;
    }

    @Override
    public Fornecedor buscaFornecedorPorId(UUID idFornecedor) {
        log.info("[start] FornecedorInfraRepository - buscaFornecedorPorId ");
        var fornecedorPorId = fornecedorSpringDataJPARepository.findById(idFornecedor)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "FORNECEDOR NÃO ENCONTRADO!"));;
        log.info("[finish] FornecedorInfraRepository - buscaFornecedorPorId ");
        return fornecedorPorId;
    }
}
