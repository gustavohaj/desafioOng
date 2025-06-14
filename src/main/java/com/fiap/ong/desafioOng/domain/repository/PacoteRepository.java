package com.fiap.ong.desafioOng.domain.repository;

import com.fiap.ong.desafioOng.domain.entity.PacoteRecebido;

public interface PacoteRepository {

    PacoteRecebido salvar(PacoteRecebido pacote) throws IllegalArgumentException;
}
