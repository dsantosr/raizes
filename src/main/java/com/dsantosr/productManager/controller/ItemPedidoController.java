package com.dsantosr.productManager.controller;

import com.dsantosr.productManager.model.ItemPedido;
import com.dsantosr.productManager.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/itempedido")
@Tag(name = "ItemPedido", description = "EndPoints to manage items in an order")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @Operation(summary = "Cria um item de pedido", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Item não criado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping("/{pedido_id}/{produto_id}/{quantidade}")
    public ResponseEntity<ItemPedido> create(
            @PathVariable(value = "pedido_id") Long pedido_id,
            @PathVariable(value = "produto_id") Long produto_id,
            @PathVariable(value = "quantidade") int quantidade
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedidoService.create(pedido_id, produto_id, quantidade));
    }
}