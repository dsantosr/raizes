package com.dsantosr.productManager.service;

import com.dsantosr.productManager.model.Pedido;
import com.dsantosr.productManager.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido create(Pedido Pedido) {
        return repository.save(Pedido);
    }

    public Pedido findById(Long id) {
        return repository.findById(id).get();
    }

    public Pedido getById(Long id){
        Optional<Pedido> Pedido = repository.findById(id);
        return Pedido.get();
    }

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
