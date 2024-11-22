package com.luizfilipehenriquelenis.restauranteAPI.model;

import java.util.List;

public record PedidoResponse(
        Funcionario funcionario,
        String status,
        Mesa mesa,
        Double precoTotal,
        List<MenuItem> itemList)
{
    public static PedidoResponse from(Pedido pedido){
        return new PedidoResponse(
          pedido.getFuncionario(),
          pedido.getStatus(),
          pedido.getMesa(),
          pedido.getPrecoTotal(),
          pedido.getItems()
        );
    }
}
