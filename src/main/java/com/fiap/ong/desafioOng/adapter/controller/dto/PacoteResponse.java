package com.fiap.ong.desafioOng.adapter.controller.dto;

import java.util.List;

public class PacoteResponse {
    public Long id;
    public List<ItemRespose> itens;

    public static class ItemRespose {
        public String produto;
        public String quantidade;
        public String unidade;
    }
}
