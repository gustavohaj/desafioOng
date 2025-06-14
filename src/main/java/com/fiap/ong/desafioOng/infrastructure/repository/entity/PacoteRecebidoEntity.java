package com.fiap.ong.desafioOng.infrastructure.repository.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pacote_recebido")
public class PacoteRecebidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataRecebimento;

    @OneToMany(mappedBy = "pacote", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemRecebidoEntity> itens;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }
    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
    public List<ItemRecebidoEntity> getItens() {
        return itens;
    }
    public void setItens(List<ItemRecebidoEntity> itens) {
        this.itens = itens;
    }



}
