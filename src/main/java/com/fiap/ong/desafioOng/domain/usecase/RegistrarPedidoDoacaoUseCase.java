package com.fiap.ong.desafioOng.domain.usecase;

import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;

public interface RegistrarPedidoDoacaoUseCase {
    PedidoDoacao executar(PedidoDoacao pedido);
}
