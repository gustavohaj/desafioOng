package com.fiap.ong.desafioOng.infrastructure.repository.jpa;

import com.fiap.ong.desafioOng.infrastructure.repository.entity.PedidoDoacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoJpaRepository extends JpaRepository<PedidoDoacaoEntity, Long> {

}
