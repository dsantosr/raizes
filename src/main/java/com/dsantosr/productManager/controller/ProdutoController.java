package com.dsantosr.productManager.controller;

import com.dsantosr.productManager.model.Produto;
import com.dsantosr.productManager.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
@Tag(name = "Produto", description = "EndPoints to manage produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(summary = "Cria um produto", method = "POST")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Produto não criado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(produto));
    }

    @Operation(summary = "Realiza a busca de um produto", method = "GET")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto(s) não encontrado(s)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Operation(summary = "Realiza a busca por todos os produtos", method = "GET")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produtos(s) não encontrado(s)"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @Operation(summary = "Realiza a atualização de um produto", method = "PUT")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }

    @Operation(summary = "Realiza a remoção de um produto", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Produto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })

    @PutMapping(value = "/saidaEstoque/{id}/{quantidade}")
    @Transactional
    public ResponseEntity<String> saidaEstoqueUpdate(@PathVariable(value = "id") Long id, @PathVariable(value = "quantidade") int quantidade) {
        if(service.saidaEstoque(id, quantidade)){
            return ResponseEntity.ok().body("Movimentação de estoque atualizada! (Tipo saída)");
        }
        return ResponseEntity.ok().body("Quantidade Inválida! (Quantidade de saída maior que o estoque)");
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })

    @PutMapping(value = "/entradaEstoque/{id}/{quantidade}")
    @Transactional
    public ResponseEntity<String> entradaEstoqueUpdate(@PathVariable(value = "id") Long id, @PathVariable(value = "quantidade") int quantidade) {
        if(service.entradaEstoque(id, quantidade)){
            return ResponseEntity.ok().body("Movimentação de estoque atualizada! (Tipo entrada)");
        }
        return ResponseEntity.ok().body("Quantidade Inválida! (Quantidade de entrada negativa)");
    }
}
