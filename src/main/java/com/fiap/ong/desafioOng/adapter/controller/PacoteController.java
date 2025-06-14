package com.fiap.ong.desafioOng.adapter.controller;

import com.fiap.ong.desafioOng.adapter.controller.dto.RegistrarPacoteRequest;
import com.fiap.ong.desafioOng.domain.entity.ItemRecebido;
import com.fiap.ong.desafioOng.domain.entity.PacoteRecebido;
import com.fiap.ong.desafioOng.domain.entity.UnidadeMedida;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPacoteRecebidoUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    private final RegistrarPacoteRecebidoUseCase registrarPacoteRecebidoUseCase;

    public PacoteController(RegistrarPacoteRecebidoUseCase registrarPacoteRecebidoUseCase) {
        this.registrarPacoteRecebidoUseCase = registrarPacoteRecebidoUseCase;
    }

    @PostMapping
    public void registrarPacote(@RequestBody RegistrarPacoteRequest request) {

        List<ItemRecebido> itens = request.itens.stream().map(item ->
                new ItemRecebido(
                        item.produto,
                        item.quantidade,
                        UnidadeMedida.valueOf(item.unidade)
                )).toList();

        PacoteRecebido pacote = new PacoteRecebido(request.dataRecebimento, itens);
        registrarPacoteRecebidoUseCase.executar(pacote);

    }

}
