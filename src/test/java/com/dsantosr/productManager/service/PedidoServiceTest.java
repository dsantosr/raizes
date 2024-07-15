package com.dsantosr.productManager.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsantosr.productManager.model.Pedido;
import com.dsantosr.productManager.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    private Pedido pedido;
    private List<Pedido> pedidos;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pedido = new Pedido();
        pedido.setId(1L);
        pedidos = new ArrayList<>();
        pedidos.add(pedido);
    }

    @Test
    public void testCreate() {
        when(repository.save(any(Pedido.class))).thenReturn(pedido);

        Pedido created = service.create(pedido);

        assertNotNull(created);
        assertEquals(pedido.getId(), created.getId());
        verify(repository, times(1)).save(pedido);
    }

    @Test
    public void testFindById() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(pedido));

        Pedido found = service.findById(1L);

        assertNotNull(found);
        assertEquals(pedido.getId(), found.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        Pedido updatedPedido = new Pedido();
        updatedPedido.setId(1L);

        when(repository.findById(anyLong())).thenReturn(Optional.of(pedido));
        when(repository.save(any(Pedido.class))).thenReturn(updatedPedido);

        Pedido updated = service.update(updatedPedido);

        assertNotNull(updated);
        assertEquals(updatedPedido.getId(), updated.getId());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(updatedPedido);
    }

    @Test
    public void testGetAll() {
        when(repository.findAll()).thenReturn(pedidos);

        List<Pedido> result = service.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        doNothing().when(repository).deleteById(anyLong());

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}

