package com.fiap.ong.desafioOng.domain.usecase;

import com.fiap.ong.desafioOng.domain.entity.PacoteRecebido;

public interface RegistrarPacoteRecebidoUseCase {

    PacoteRecebido executar(PacoteRecebido pacoteRecebido) throws IllegalArgumentException;
}
