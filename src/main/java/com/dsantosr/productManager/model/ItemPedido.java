package com.dsantosr.productManager.model;

import com.dsantosr.productManager.model.pk.ItemPedidoId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ItemPedidoId.class)
public class ItemPedido implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private Pedido pedido_id;

    private int quantidade;

    public Long getPedido() {
        return this.pedido_id.getId();
    }

    public Long getProduto() {
        return this.produto_id.getId();
    }

    public Double getPreco(){
        return quantidade*produto_id.getPreco();
    }
}