package com.fiap.ong.desafioOng.application.service;

import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPedidoService {
    private final PedidoRepository pedidoRepository;

    public ListarPedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoDoacao> executar() {
        return pedidoRepository.listarTodos();
    }
}
