package com.fiap.ong.desafioOng.infrastructure.repository;

import com.fiap.ong.desafioOng.domain.entity.PacoteRecebido;
import com.fiap.ong.desafioOng.domain.repository.PacoteRepository;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.ItemRecebidoEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.PacoteRecebidoEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.UnidadeMedidaEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.PacoteJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PacoteRepositoryImpl implements PacoteRepository {

    private final PacoteJpaRepository pacoteJpaRepository;

    public PacoteRepositoryImpl(PacoteJpaRepository pacoteJpaRepository) {
        this.pacoteJpaRepository = pacoteJpaRepository;
    }



    @Override
    public PacoteRecebido salvar( PacoteRecebido pacote) throws IllegalArgumentException {
        PacoteRecebidoEntity entity = new PacoteRecebidoEntity();

        entity.setDataRecebimento(pacote.getDataRecebimento());

        List<ItemRecebidoEntity> itens = pacote.getItensRecebidos().stream().map(item -> {
            ItemRecebidoEntity itemEntity = new ItemRecebidoEntity();
                    itemEntity.setProduto(item.getProduto());
                    itemEntity.setQuantidade(item.getQuantidade());
                    itemEntity.setUnidade(UnidadeMedidaEntity.valueOf(item.getUnidade().name()));
                    itemEntity.setPacote(entity);
                    return itemEntity;
                }).collect(Collectors.toList());

        entity.setItens(itens);

        PacoteRecebidoEntity salvo = pacoteJpaRepository.save(entity);

        return pacote;
    }
}
