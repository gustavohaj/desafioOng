package com.fiap.ong.desafioOng.infrastructure.repository.jpa;

import java.math.BigDecimal;

public interface EstoqueRepository {
    BigDecimal obterQuantidadeDisponivel(String nomeProduto);
    void baixarEstoque(String nomeProduto, BigDecimal quantidade);
}
