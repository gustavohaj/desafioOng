package com.fiap.ong.desafioOng.adapter.controller;



import com.fiap.ong.desafioOng.adapter.controller.dto.RegistrarPedidoRequest;
import com.fiap.ong.desafioOng.domain.entity.ItemPedido;
import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.entity.UnidadeMedida;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPedidoDoacaoUseCase;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RegistrarPedidoDoacaoUseCase registrarPedidoDoacaoUseCase;

    public PedidoController(RegistrarPedidoDoacaoUseCase registrarPedidoDoacaoUseCase) {
        this.registrarPedidoDoacaoUseCase = registrarPedidoDoacaoUseCase;
    }

    @PostMapping
    public void registrarPedido(@RequestBody RegistrarPedidoRequest request) {
        List<ItemPedido> itens = request.itens.stream().map(item ->
                new ItemPedido(
                        item.produto,
                        item.quantidade,
                        UnidadeMedida.valueOf(item.unidade)
                )
        ).collect(Collectors.toList());

        PedidoDoacao pedido = new PedidoDoacao(request.dataPedido, itens);
        registrarPedidoDoacaoUseCase.executar(pedido);
    }
}