package com.fiap.ong.desafioOng.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDoacao {
    private Long id;
    private LocalDateTime dataPedido;
    private List<ItemPedido> itens;

    public PedidoDoacao(LocalDateTime dataPedido, List<ItemPedido> itens) {
        this.dataPedido = dataPedido;
        this.itens = itens;
    }

    public Long getId() { return id; }
    public LocalDateTime getDataPedido() { return dataPedido; }
    public List<ItemPedido> getItens() { return itens; }

}
