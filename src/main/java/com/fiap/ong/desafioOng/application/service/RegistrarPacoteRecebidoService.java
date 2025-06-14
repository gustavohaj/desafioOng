package com.fiap.ong.desafioOng.application.service;

import com.fiap.ong.desafioOng.domain.entity.PacoteRecebido;
import com.fiap.ong.desafioOng.domain.repository.PacoteRepository;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPacoteRecebidoUseCase;

public class RegistrarPacoteRecebidoService implements RegistrarPacoteRecebidoUseCase {

    private final PacoteRepository pacoteRepository;


    public RegistrarPacoteRecebidoService(PacoteRepository pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }


    @Override
    public PacoteRecebido executar(PacoteRecebido pacoteRecebido) throws IllegalArgumentException {
        PacoteRecebido pacote = new PacoteRecebido();
        return pacoteRepository.salvar(pacote);
    }
}
