package com.fiap.ong.desafioOng.application.service;

import com.fiap.ong.desafioOng.domain.entity.ItemPedido;
import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.EstoqueRepository;

import java.math.BigDecimal;

public class ValidadorPedidoService {

    private final EstoqueRepository estoqueRepository;

    public ValidadorPedidoService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public boolean podeAtender(PedidoDoacao pedido) {
        for (ItemPedido item : pedido.getItens()) {
            BigDecimal quantidadeEmEstoque = estoqueRepository.obterQuantidadeDisponivel(item.getNomeProduto());

            if (quantidadeEmEstoque == null || quantidadeEmEstoque.compareTo(BigDecimal.ZERO) <= 0) {
                return false; // Não há estoque suficiente para atender o pedido
            }
        }
        return true; // Pedido pode ser atendido
    }
}
