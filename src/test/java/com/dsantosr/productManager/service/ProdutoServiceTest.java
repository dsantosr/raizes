package com.dsantosr.productManager.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsantosr.productManager.model.Produto;
import com.dsantosr.productManager.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    private Produto produto;
    private List<Produto> produtos;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setDescricao("Descricao Teste");
        produto.setPreco(10.0);
        produto.setQuantidadeEmEstoque(100);
        produtos = new ArrayList<>();
        produtos.add(produto);
    }

    @Test
    public void testCreate() {
        when(repository.save(any(Produto.class))).thenReturn(produto);

        Produto created = service.create(produto);

        assertNotNull(created);
        assertEquals(produto.getId(), created.getId());
        verify(repository, times(1)).save(produto);
    }

    @Test
    public void testFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(produto));

        Produto found = service.findById(1L);

        assertNotNull(found);
        assertEquals(produto.getId(), found.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        Produto updatedProduto = new Produto();
        updatedProduto.setId(1L);

        when(repository.findById(anyLong())).thenReturn(Optional.of(produto));
        when(repository.save(any(Produto.class))).thenReturn(updatedProduto);

        Produto updated = service.update(updatedProduto);

        assertNotNull(updated);
        assertEquals(updatedProduto.getId(), updated.getId());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(updatedProduto);
    }

    @Test
    public void testGetAll() {
        when(repository.findAll()).thenReturn(produtos);

        List<Produto> result = service.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testDelete() {
        doNothing().when(repository).deleteById(anyLong());

        service.delete(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}

