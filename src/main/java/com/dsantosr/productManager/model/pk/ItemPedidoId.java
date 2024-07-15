package com.dsantosr.productManager.model.pk;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ItemPedidoId implements Serializable {
    private Long produto_id;
    private Long pedido_id;
}