package com.fiap.ong.desafioOng.adapter.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class RegistrarPacoteRequest {
    public LocalDateTime dataRecebimento;
    public List<ItemRequest> itens;

    public static class ItemRequest {
        public String produto;
        public BigDecimal quantidade;
        public String unidade;


    }
}
