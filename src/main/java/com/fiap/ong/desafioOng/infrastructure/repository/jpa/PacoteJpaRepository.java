package com.fiap.ong.desafioOng.infrastructure.repository.jpa;

import com.fiap.ong.desafioOng.infrastructure.repository.entity.PacoteRecebidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteJpaRepository extends JpaRepository<PacoteRecebidoEntity, Long> {

}
