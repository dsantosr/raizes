package com.dsantosr.productManager.service;

import com.dsantosr.productManager.model.Produto;
import com.dsantosr.productManager.repository.ProdutoRepository;
import com.dsantosr.productManager.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Produto obj) {
        Optional<Produto> newObj = repository.findById(obj.getId());
        freeUpdate(newObj, obj);
        return repository.save(newObj.get());
    }

    public void freeUpdate(Optional<Produto> newObj, Produto obj) {
        newObj.get().setNome(obj.getNome());
        newObj.get().setDescricao(obj.getDescricao());
        newObj.get().setPreco(obj.getPreco());
        newObj.get().setQuantidadeEmEstoque(obj.getQuantidadeEmEstoque());
    }

    public Produto findById(Long id){
        Optional<Produto> produto = repository.findById(id);
        return produto.get();
    }

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public boolean saidaEstoque(Long id, Integer quantidade) {
        var produto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        int estoque = produto.getQuantidadeEmEstoque();
        if (estoque >= quantidade) {
            var prod = produto;
            prod.setQuantidadeEmEstoque(estoque - quantidade);
            return true;
        }
        return false;
    }

    public boolean entradaEstoque(Long id, Integer quantidade) {
        var produto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        int estoque = produto.getQuantidadeEmEstoque();
        if (quantidade > 0) {
            var prod = produto;
            prod.setQuantidadeEmEstoque(estoque + quantidade);
            return true;
        }
        return false;
    }
}