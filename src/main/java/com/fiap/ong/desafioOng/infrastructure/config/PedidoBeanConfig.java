package com.fiap.ong.desafioOng.infrastructure.config;

import com.fiap.ong.desafioOng.application.service.RegistrarPedidoDoacaoService;
import com.fiap.ong.desafioOng.domain.repository.PedidoRepository;
import com.fiap.ong.desafioOng.domain.usecase.RegistrarPedidoDoacaoUseCase;
import com.fiap.ong.desafioOng.infrastructure.repository.PedidoRepositoryImpl;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.PedidoJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {
    @Bean
    public PedidoRepository pedidoRepository(PedidoJpaRepository jpaRepository) {
        return new PedidoRepositoryImpl(jpaRepository);
    }

    @Bean
    public RegistrarPedidoDoacaoUseCase registrarPedidoDoacaoUseCase(PedidoRepository repository) {
        return new RegistrarPedidoDoacaoService(repository);
    }
}
