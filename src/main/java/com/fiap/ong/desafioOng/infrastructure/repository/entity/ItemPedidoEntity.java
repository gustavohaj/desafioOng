package com.fiap.ong.desafioOng.infrastructure.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;
    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    private UnidadeMedidaEntity unidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private PedidoDoacaoEntity pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedidaEntity getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMedidaEntity unidade) {
        this.unidade = unidade;
    }

    public PedidoDoacaoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDoacaoEntity pedido) {
        this.pedido = pedido;
    }
}
