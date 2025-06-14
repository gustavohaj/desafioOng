package com.fiap.ong.desafioOng.domain.entity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacoteRecebido {
    private Long idPacoteRecebido;
    private LocalDateTime dataRecebimento;
    private List<ItemRecebido> itensRecebidos = new ArrayList<>();


    public PacoteRecebido(LocalDateTime dataRecebimento, List<ItemRecebido> itensRecebidos) {
        this.dataRecebimento = dataRecebimento;
        this.itensRecebidos = itensRecebidos;
    }

    public PacoteRecebido() {

    }

    public Long getIdPacoteRecebido() {

        return idPacoteRecebido;
    }

    public LocalDateTime getDataRecebimento() {

        return dataRecebimento;
    }

    public List<ItemRecebido> getItensRecebidos() {
        return itensRecebidos;
    }


}
