package com.fiap.ong.desafioOng.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDoacao {
    private Long id;
    private LocalDateTime dataPedido;
    private List<ItemPedido> itens;
    private boolean entregue;

    public PedidoDoacao(LocalDateTime dataPedido, List<ItemPedido> itens) {
        this.dataPedido = dataPedido;
        this.itens = itens;
    }

    public PedidoDoacao() {
        // Construtor padrão necessário para frameworks como JPA
    }

    public Long getId() { return id; }
    public LocalDateTime getDataPedido() { return dataPedido; }
    public List<ItemPedido> getItens() { return itens; }
    public void setId(Long id) { this.id = id; }
    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
    public void marcarComoEntregue() {
        this.entregue = true;
    }



}
