package com.fiap.ong.desafioOng.application.service;

import com.fiap.ong.desafioOng.domain.entity.ItemPedido;
import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.repository.PedidoRepository;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.EstoqueRepository;
import jakarta.transaction.Transactional;

public class EntregaPedidoService {

    private  PedidoRepository pedidoRepository;
    private  EstoqueRepository estoqueRepository;
    private  ValidadorPedidoService validadorPedidoService;


    public EntregaPedidoService(PedidoRepository pedidoRepository, EstoqueRepository estoqueRepository, ValidadorPedidoService validadorPedidoService) {
        this.pedidoRepository = pedidoRepository;
        this.estoqueRepository = estoqueRepository;
        this.validadorPedidoService = validadorPedidoService;
    }


    @Transactional
    public void entregar(Long idPedido) {
        // Buscar o pedido pelo ID
        PedidoDoacao pedido = pedidoRepository.buscarPorId(idPedido);

        // Validar se o pedido pode ser atendido
        if (validadorPedidoService.podeAtender(pedido)) {
            throw new IllegalArgumentException("Estoque insuficiente para atender ao pedido.");
        }
        for (ItemPedido item : pedido.getItens()) {
            estoqueRepository.baixarEstoque(item.getNomeProduto(), item.getQuantidade());
        }

        pedido.marcarComoEntregue();
        pedidoRepository.salvar(pedido);
    }

}
