package com.fiap.ong.desafioOng.domain.repository;

import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;

import java.util.List;

public interface PedidoRepository {
    PedidoDoacao salvar(PedidoDoacao pedido);
    List<PedidoDoacao> listarTodos();

    Long buscarPorId(Long idPedido);
}
