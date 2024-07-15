package com.dsantosr.productManager.service;

import com.dsantosr.productManager.model.Pedido;
import com.dsantosr.productManager.repository.PedidoRepository;
import com.dsantosr.productManager.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public Pedido create(Pedido Pedido) {
        repository.save(Pedido);
        return repository.save(Pedido);
    }

    public Pedido findById(Long id){
        var pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return pedido;
    }

    public Pedido update(Pedido obj) {
        Optional<Pedido> newObj = repository.findById(obj.getId());
        freeUpdate(newObj, obj);
        return repository.save(newObj.get());
    }

    public void freeUpdate(Optional<Pedido> newObj, Pedido obj) {
        newObj.get().setId(obj.getId());
        newObj.get().setItems(obj.getItems());
    }

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}