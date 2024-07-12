package com.dsantosr.productManager.service;

import com.dsantosr.productManager.model.Pedido;
import com.dsantosr.productManager.repository.PedidoRepository;
import com.dsantosr.productManager.service.exception.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido create(Pedido Pedido) {
        return repository.save(Pedido);
    }

    public Pedido getById(Long id){
        var pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return pedido;
    }

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
