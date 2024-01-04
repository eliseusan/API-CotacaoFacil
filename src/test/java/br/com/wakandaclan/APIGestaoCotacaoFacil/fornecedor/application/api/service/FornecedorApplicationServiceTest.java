package br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.requests.FornecedorRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.controller.responses.FornecedorResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

    @Test
    void testBuscaTodosFornecedores() {
        // Mocking
        List<Fornecedor> fornecedoresMock = Arrays.asList(
                Fornecedor.builder()
                        .idFornecedor(UUID.randomUUID())
                        .nomeFantasia("Fornecedor1")
                        .razaoSocial("Razao Social1")
                        .cnpj("1234567891")
                        .dataHoraDoCadastro(LocalDateTime.now())
                        .build(),
                Fornecedor.builder()
                        .idFornecedor(UUID.randomUUID())
                        .nomeFantasia("Fornecedor2")
                        .razaoSocial("Razao Social2")
                        .cnpj("1234567892")
                        .dataHoraDoCadastro(LocalDateTime.now())
                        .build()
        );

        when(fornecedorRepository.buscaTodosFornecedores()).thenReturn(fornecedoresMock);

        // Test
        List<FornecedorListResponse> response = fornecedorApplicationService.buscaTodosFornecedores();

        // Verify
        verify(fornecedorRepository, times(1)).buscaTodosFornecedores();
        assertNotNull(response);
        assertEquals(fornecedoresMock.size(), response.size());
    }

    @Test
    void testBuscaFornecedorPorId() {
        // Mocking
        UUID idFornecedor = UUID.randomUUID();
        Fornecedor fornecedorMock = Fornecedor.builder()
                .idFornecedor(idFornecedor)
                .nomeFantasia("FornecedorTest")
                .razaoSocial("Razao Social Test")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(fornecedorRepository.buscaFornecedorPorId(idFornecedor)).thenReturn(fornecedorMock);

        // Test
        FornecedorDetalhadoListResponse response = fornecedorApplicationService.buscaFornecedorPorId(idFornecedor);

        // Verify
        verify(fornecedorRepository, times(1)).buscaFornecedorPorId(idFornecedor);
        assertNotNull(response);
        assertEquals(idFornecedor, response.getIdFornecedor());
    }

    @Test
    void testDeletaFornecedorPorId() {
        // Mocking
        UUID idFornecedor = UUID.randomUUID();
        Fornecedor fornecedorMock = Fornecedor.builder()
                .idFornecedor(idFornecedor)
                .nomeFantasia("FornecedorTest")
                .razaoSocial("Razao Social Test")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(fornecedorRepository.buscaFornecedorPorId(idFornecedor)).thenReturn(fornecedorMock);

        // Test
        fornecedorApplicationService.deletaFornecedorPorId(idFornecedor);

        // Verify
        verify(fornecedorRepository, times(1)).buscaFornecedorPorId(idFornecedor);
        verify(fornecedorRepository, times(1)).deletaFornecedorPorId(fornecedorMock);
    }

    @Test
    void testAlteraFornecedor() {
        // Mocking
        UUID idFornecedor = UUID.randomUUID();
        FornecedorAlteracaoRequest alteracaoRequest = FornecedorAlteracaoRequest.builder()
                .nomeFantasia("Novo Nome")
                .razaoSocial("Nova Razao Social")
                .build();

        Fornecedor fornecedorMock = Fornecedor.builder()
                .idFornecedor(idFornecedor)
                .nomeFantasia("Nome Antigo")
                .razaoSocial("Razao Social Antiga")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(fornecedorRepository.buscaFornecedorPorId(idFornecedor)).thenReturn(fornecedorMock);

        // Test
        fornecedorApplicationService.alteraFornecedor(idFornecedor, alteracaoRequest);

        // Verify
        verify(fornecedorRepository, times(1)).buscaFornecedorPorId(idFornecedor);
        verify(fornecedorRepository, times(1)).salva(argThat(fornecedor ->
                fornecedor.getIdFornecedor().equals(idFornecedor) &&
                        fornecedor.getNomeFantasia().equals("Novo Nome") &&
                        fornecedor.getRazaoSocial().equals("Nova Razao Social")
        ));
    }
}