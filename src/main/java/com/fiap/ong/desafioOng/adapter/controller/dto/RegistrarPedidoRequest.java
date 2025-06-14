package com.fiap.ong.desafioOng.adapter.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RegistrarPedidoRequest {
    public LocalDateTime dataPedido;
    public List<ItemPedidoRequest> itens;

    public static class ItemPedidoRequest {
        public String produto;
        public BigDecimal quantidade;
        public String unidade;
    }
}