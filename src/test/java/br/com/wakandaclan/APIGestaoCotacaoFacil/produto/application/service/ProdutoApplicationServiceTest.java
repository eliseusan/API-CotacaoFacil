package br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.service;

import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.application.api.repository.FornecedorRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.fornecedor.domain.entities.Fornecedor;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoAlteracaoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.requests.ProdutoRequest;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDetalhadoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoDoFornecedorListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoListResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.api.responses.ProdutoResponse;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.application.repository.ProdutoRepository;
import br.com.wakandaclan.APIGestaoCotacaoFacil.produto.domain.entities.Produto;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@Slf4j
@ExtendWith(MockitoExtension.class)
class ProdutoApplicationServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private FornecedorRepository fornecedorRepository;

    @InjectMocks
    private ProdutoApplicationService produtoApplicationService;

    @Test
    void testCriaProduto() {
        // Mocking
        UUID idFornecedorProduto = UUID.randomUUID();
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .descricao("Descrição do Produto")
                .marca("Marca do Produto")
                .codigoDeBarra("123456789")
                .valor(BigDecimal.TEN)
                .build();

        Fornecedor fornecedorMock = Fornecedor.builder()
                .idFornecedor(idFornecedorProduto)
                .nomeFantasia("Nome do Fornecedor")
                .razaoSocial("Razao Social do Fornecedor")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(fornecedorRepository.buscaFornecedorPorId(idFornecedorProduto)).thenReturn(fornecedorMock);
        when(produtoRepository.salvaProduto(any(Produto.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Test
        ProdutoResponse response = produtoApplicationService.criaProduto(idFornecedorProduto, produtoRequest);

        // Verify
        verify(fornecedorRepository, times(1)).buscaFornecedorPorId(idFornecedorProduto);
        verify(produtoRepository, times(1)).salvaProduto(any(Produto.class));
        assertNotNull(response);
    }

    @Test
    void testBuscaProdutoPorId() {
        // Mocking
        UUID idProduto = UUID.randomUUID();
        Produto produtoMock = Produto.builder()
                .idProduto(idProduto)
                .idFornecedorProduto(UUID.randomUUID())
                .descricao("Descrição do Produto")
                .marca("Marca do Produto")
                .codigoDeBarra("123456789")
                .valor(BigDecimal.TEN)
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(produtoRepository.buscaProdutoPorId(idProduto)).thenReturn(produtoMock);

        // Test
        ProdutoDetalhadoListResponse response = produtoApplicationService.buscaProdutoPorId(idProduto);

        // Verify
        verify(produtoRepository, times(1)).buscaProdutoPorId(idProduto);
        assertNotNull(response);
        assertEquals(idProduto, response.getIdProduto());
        assertEquals("Descrição do Produto", response.getDescricao());
        // Adicione mais verificações conforme necessário.
    }

    @Test
    void testDeletaProdutoPorId() {
        // Mocking
        UUID idProduto = UUID.randomUUID();
        Produto produtoMock = Produto.builder()
                .idProduto(idProduto)
                .idFornecedorProduto(UUID.randomUUID())
                .descricao("Descrição do Produto")
                .marca("Marca do Produto")
                .codigoDeBarra("123456789")
                .valor(BigDecimal.TEN)
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(produtoRepository.buscaProdutoPorId(idProduto)).thenReturn(produtoMock);

        // Test
        produtoApplicationService.deletaProdutoPorId(idProduto);

        // Verify
        verify(produtoRepository, times(1)).buscaProdutoPorId(idProduto);
        verify(produtoRepository, times(1)).deletaProdutoPorId(produtoMock);
    }

    @Test
    void testAlteraProduto() {
        // Mocking
        UUID idProduto = UUID.randomUUID();
        ProdutoAlteracaoRequest alteracaoRequest = ProdutoAlteracaoRequest
                .builder()
                .descricao("Nova Descrição")
                .marca("Nova Marca")
                .codigoDeBarra("987654321")
                .valor(BigDecimal.valueOf(20.0))
                .build();


        Produto produtoMock = Produto.builder()
                .idProduto(idProduto)
                .idFornecedorProduto(UUID.randomUUID())
                .descricao("Descrição Antiga")
                .marca("Marca Antiga")
                .codigoDeBarra("123456789")
                .valor(BigDecimal.TEN)
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(produtoRepository.buscaProdutoPorId(idProduto)).thenReturn(produtoMock);

        // Test
        produtoApplicationService.alteraProduto(idProduto, alteracaoRequest);

        // Verify
        verify(produtoRepository, times(1)).buscaProdutoPorId(idProduto);
        verify(produtoRepository, times(1)).salvaProduto(produtoMock);
        assertEquals("Nova Descrição", produtoMock.getDescricao());
        assertEquals("Nova Marca", produtoMock.getMarca());
        assertEquals("987654321", produtoMock.getCodigoDeBarra());
        assertEquals(BigDecimal.valueOf(20.0), produtoMock.getValor());
        assertNotNull(produtoMock.getDataHoraDaUltimaAlteracao());
    }

    @Test
    void testBuscaProdutoPorIdFornecedor() {
        // Mocking
        UUID idFornecedorProduto = UUID.randomUUID();
        Fornecedor fornecedorMock = Fornecedor.builder()
                .idFornecedor(idFornecedorProduto)
                .nomeFantasia("Nome Fantasia")
                .razaoSocial("Razão Social")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        when(fornecedorRepository.buscaFornecedorPorId(idFornecedorProduto)).thenReturn(fornecedorMock);

        List<Produto> produtosFornecedor = List.of(
                Produto.builder()
                        .idProduto(UUID.randomUUID())
                        .idFornecedorProduto(idFornecedorProduto)
                        .descricao("Descrição1")
                        .marca("Marca1")
                        .codigoDeBarra("1234567891")
                        .valor(BigDecimal.TEN)
                        .build(),
                Produto.builder()
                        .idProduto(UUID.randomUUID())
                        .idFornecedorProduto(idFornecedorProduto)
                        .descricao("Descrição2")
                        .marca("Marca2")
                        .codigoDeBarra("1234567892")
                        .valor(BigDecimal.TEN)
                        .build()
        );

        when(produtoRepository.buscaProdutoPorIdFornecedor(idFornecedorProduto)).thenReturn(produtosFornecedor);

        // Test
        List<ProdutoDoFornecedorListResponse> response = produtoApplicationService.buscaProdutoPorIdFornecedor(idFornecedorProduto);

        // Verify
        verify(fornecedorRepository, times(1)).buscaFornecedorPorId(idFornecedorProduto);
        verify(produtoRepository, times(1)).buscaProdutoPorIdFornecedor(idFornecedorProduto);
        assertNotNull(response);
        assertEquals(produtosFornecedor.size(), response.size());

    }

    @Test
    void testBuscaTodosProdutos() {
        // Mocking
        Produto produto1 = Produto.builder()
                .idProduto(UUID.randomUUID())
                .idFornecedorProduto(UUID.randomUUID())
                .descricao("Descrição1")
                .marca("Marca1")
                .codigoDeBarra("1234567891")
                .valor(BigDecimal.TEN)
                .build();

        Produto produto2 = Produto.builder()
                .idProduto(UUID.randomUUID())
                .idFornecedorProduto(UUID.randomUUID())
                .descricao("Descrição2")
                .marca("Marca2")
                .codigoDeBarra("1234567892")
                .valor(BigDecimal.TEN)
                .build();

        Fornecedor fornecedor1 = Fornecedor.builder()
                .idFornecedor(UUID.randomUUID())
                .nomeFantasia("Nome Fantasia 1")
                .razaoSocial("Razão Social 1")
                .cnpj("123456789")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        Fornecedor fornecedor2 = Fornecedor.builder()
                .idFornecedor(UUID.randomUUID())
                .nomeFantasia("Nome Fantasia 2")
                .razaoSocial("Razão Social 2")
                .cnpj("987654321")
                .dataHoraDoCadastro(LocalDateTime.now())
                .build();

        List<Produto> produtos = List.of(produto1, produto2);
        List<Fornecedor> fornecedores = List.of(fornecedor1, fornecedor2);

        when(produtoRepository.buscaTodosProdutos()).thenReturn(produtos);
        when(fornecedorRepository.buscaTodosFornecedores()).thenReturn(fornecedores);

        // Test
        List<ProdutoListResponse> response = produtoApplicationService.buscaTodosProdutos();

        // Verify
        verify(produtoRepository, times(1)).buscaTodosProdutos();
        verify(fornecedorRepository, times(1)).buscaTodosFornecedores();
        assertNotNull(response);
    }
}
