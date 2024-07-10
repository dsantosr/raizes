package com.dsantosr.productManager.controller;

import com.dsantosr.productManager.model.Produto;
import com.dsantosr.productManager.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(produto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
