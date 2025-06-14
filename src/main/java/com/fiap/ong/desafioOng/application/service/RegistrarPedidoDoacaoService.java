package com.fiap.ong.desafioOng.application.service;

import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.repository.PedidoRepository;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPedidoDoacaoUseCase;

public class RegistrarPedidoDoacaoService implements RegistrarPedidoDoacaoUseCase {

    private final PedidoRepository pedidoRepository;

    public RegistrarPedidoDoacaoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoDoacao executar(PedidoDoacao pedido) {
        // Aqui pode entrar lógica de validação (ex: verificar duplicidade, regras de negócio)
        return pedidoRepository.salvar(pedido);
    }
}
