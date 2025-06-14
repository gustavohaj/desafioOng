package com.fiap.ong.desafioOng.infrastructure.config;

import com.fiap.ong.desafioOng.application.service.RegistrarPacoteRecebidoService;
import com.fiap.ong.desafioOng.domain.repository.PacoteRepository;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPacoteRecebidoUseCase;
import com.fiap.ong.desafioOng.infrastructure.repository.PacoteRepositoryImpl;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.PacoteJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PacoteRepository pacoteRepository(PacoteJpaRepository jpaRepo) {
        return new PacoteRepositoryImpl(jpaRepo);
    }

    @Bean
    public RegistrarPacoteRecebidoUseCase registrarPacoteUseCase(PacoteRepository repo) {
        return new RegistrarPacoteRecebidoService(repo);
    }

}
