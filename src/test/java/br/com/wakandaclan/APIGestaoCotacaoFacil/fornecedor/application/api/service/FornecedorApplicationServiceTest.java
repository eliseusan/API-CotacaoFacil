package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FornecedorApplicationServiceTest {

    @Mock
    private FornecedorRepository fornecedorRepository;

    @InjectMocks
    private FornecedorApplicationService fornecedorApplicationService;

    @Test
    void testCriaFornecedor() {
        // Mocking
        FornecedorRequest request = FornecedorRequest.builder()
                .nomeFantasia("Nome")
                .razaoSocial("Razao Social")
                .cnpj("123456789")
                .build();

        Fornecedor fornecedor = new Fornecedor(request);
        when(fornecedorRepository.salva(any(Fornecedor.class))).thenReturn(fornecedor);
        // Test
        FornecedorResponse response = fornecedorApplicationService.criaFornecedor(request);
        // Verify
        verify(fornecedorRepository, times(1)).salva(any(Fornecedor.class));
        assertNotNull(response);

    }
}