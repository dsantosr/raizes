package com.dsantosr.productManager.controller;

import com.dsantosr.productManager.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dsantosr.productManager.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.create(pedido);
    }

    @GetMapping
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @PutMapping("/{id}")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoService.create(pedido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.deleteById(id);
    }
}

