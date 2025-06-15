package com.fiap.ong.desafioOng.adapter.controller;



import com.fiap.ong.desafioOng.adapter.controller.dto.RegistrarPedidoRequest;
import com.fiap.ong.desafioOng.application.service.EntregaPedidoService;
import com.fiap.ong.desafioOng.application.service.ListarPedidoService;
import com.fiap.ong.desafioOng.application.service.ValidadorPedidoService;
import com.fiap.ong.desafioOng.domain.entity.ItemPedido;
import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.entity.UnidadeMedida;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPedidoDoacaoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final RegistrarPedidoDoacaoUseCase registrarPedidoDoacaoUseCase;
    private final ListarPedidoService listarPedidoService;
    private ValidadorPedidoService validadorPedidoService;
    private EntregaPedidoService entregarPedidoService;

    public PedidoController(RegistrarPedidoDoacaoUseCase registrarPedidoDoacaoUseCase, ListarPedidoService listarPedidoService) {
        this.registrarPedidoDoacaoUseCase = registrarPedidoDoacaoUseCase;
        this.listarPedidoService = listarPedidoService;
    }

    @PostMapping
    public void registrarPedido(@RequestBody RegistrarPedidoRequest request) {
        List<ItemPedido> itens = request.itens.stream().map(item ->
                new ItemPedido(
                        item.produto,
                        item.nomeProduto,
                        item.quantidade,
                        UnidadeMedida.valueOf(item.unidade)
                )
        ).collect(Collectors.toList());

        PedidoDoacao pedido = new PedidoDoacao(request.dataPedido, itens);
        registrarPedidoDoacaoUseCase.executar(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDoacao>> listar(){
        List<PedidoDoacao> pedidos = listarPedidoService.executar();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/validar")
    public ResponseEntity<?> validarPedido(@RequestBody PedidoDoacao pedido) {
        boolean podeAtender = validadorPedidoService.podeAtender(pedido);
        if (podeAtender) {
            return ResponseEntity.ok("Pedido pode ser atendido.");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estoque insuficiente para atender ao pedido.");
        }
    }

    @PutMapping("/entregar/{id}")
    public ResponseEntity<?> entregarPedido(@PathVariable Long id) {
        try {
            entregarPedidoService.entregar(id);
            return ResponseEntity.ok("Pedido entregue com sucesso.");
        } catch (IllegalStateException | IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

}