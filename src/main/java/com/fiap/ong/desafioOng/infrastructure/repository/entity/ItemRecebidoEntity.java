package com.fiap.ong.desafioOng.infrastructure.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "itens_recebidos")
public class ItemRecebidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produto;
    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    private UnidadeMedidaEntity unidade;

    @ManyToOne
    @JoinColumn(name = "pacote_recebido_id")
    private PacoteRecebidoEntity pacote;


    public PacoteRecebidoEntity getPacote() {
        return pacote;
    }

    public void setPacote(PacoteRecebidoEntity pacote) {
        this.pacote = pacote;
    }

    public UnidadeMedidaEntity getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMedidaEntity unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
