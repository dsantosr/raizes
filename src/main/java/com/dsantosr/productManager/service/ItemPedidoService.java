package com.dsantosr.productManager.service;

import com.dsantosr.productManager.model.ItemPedido;
import com.dsantosr.productManager.model.Pedido;
import com.dsantosr.productManager.model.Produto;
import com.dsantosr.productManager.repository.ItemPedidoRepository;
import com.dsantosr.productManager.repository.PedidoRepository;
import com.dsantosr.productManager.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {
    @Autowired
    private ProdutoRepository repositoryProduto;

    @Autowired
    private PedidoRepository repositoryPedido;

    @Autowired
    private ItemPedidoRepository repositoryItemPedido;

    @Transactional
    public ItemPedido create(Long produtoId, Long pedidoId, int quantidade) {
        Produto produto = repositoryProduto.findById(produtoId)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        if (produto.getQuantidadeEmEstoque() < quantidade) {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente");
        }

        Pedido pedido = repositoryPedido.findById(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        // Criar ItemPedido
        ItemPedido itemPedido = new ItemPedido(produto, pedido, quantidade);
        repositoryItemPedido.save(itemPedido);

        // Decrementar a quantidade em estoque do produto
        produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
        repositoryProduto.save(produto);

        return itemPedido;
    }

}