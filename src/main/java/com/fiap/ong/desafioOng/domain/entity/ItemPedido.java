package com.fiap.ong.desafioOng.domain.entity;

import java.math.BigDecimal;

public class ItemPedido {
    private Long id;
    private String produto;
    private String nomeProduto;
    private BigDecimal quantidade;
    private UnidadeMedida unidade;

    public ItemPedido(String produto, String nomeProduto, BigDecimal quantidade, UnidadeMedida unidade) {
        if (quantidade == null || quantidade.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.produto = produto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public ItemPedido() {

    }



    public Long getId() { return id; }
    public String getProduto() { return produto; }
    public BigDecimal getQuantidade() { return quantidade; }
    public UnidadeMedida getUnidade() { return unidade; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidade(UnidadeMedida unidade) {
        this.unidade = unidade;
    }

    public void setProduto(String produto) {
    }

    public void setNomeProduto(String produto) {
    }
}
