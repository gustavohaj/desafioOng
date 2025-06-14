package com.fiap.ong.desafioOng.domain.entity;


import java.math.BigDecimal;

public class ItemRecebido {
    private Long idItemRecebido;
    private String produto;
    private BigDecimal quantidade;
    private UnidadeMedida unidade;

    public ItemRecebido(String produto, BigDecimal quantidade, UnidadeMedida unidade) {
        if (quantidade == null || quantidade.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public Long getIdItemRecebido() {
        return idItemRecebido;
    }

    public String getProduto() {
        return produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }
}
