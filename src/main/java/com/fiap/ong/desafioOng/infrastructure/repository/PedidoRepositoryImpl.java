package com.fiap.ong.desafioOng.infrastructure.repository;

import com.fiap.ong.desafioOng.domain.entity.ItemPedido;
import com.fiap.ong.desafioOng.domain.entity.PedidoDoacao;
import com.fiap.ong.desafioOng.domain.repository.PedidoRepository;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.ItemPedidoEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.PedidoDoacaoEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.entity.UnidadeMedidaEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.PedidoJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoJpaRepository pedidoJpaRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public PedidoRepositoryImpl(PedidoJpaRepository pedidoJpaRepository) {
        this.pedidoJpaRepository = pedidoJpaRepository;
    }

    @Override
    public PedidoDoacao salvar(PedidoDoacao pedido) {
        PedidoDoacaoEntity entity = new PedidoDoacaoEntity();
        entity.setDataPedido(pedido.getDataPedido());

        List<ItemPedidoEntity> itens = pedido.getItens().stream().map(item -> {
            ItemPedidoEntity itemEntity = new ItemPedidoEntity();
            itemEntity.setProduto(item.getProduto());
            itemEntity.setQuantidade(item.getQuantidade());
            itemEntity.setUnidade(UnidadeMedidaEntity.valueOf(item.getUnidade().name()));
            itemEntity.setPedido(entity);
            return itemEntity;
        }).collect(Collectors.toList());

        entity.setItens(itens);

        PedidoDoacaoEntity salvo;
        salvo = pedidoJpaRepository.save(entity);

        return pedido;
    }



    @Override
    public List<PedidoDoacao> listarTodos() {

        List<PedidoDoacaoEntity> entities = entityManager.createQuery("from PedidoDoacaoEntity", PedidoDoacaoEntity.class).getResultList();
        return entities.stream().map(this::toDomain).collect(Collectors.toList());
    }

    private PedidoDoacao toDomain(PedidoDoacaoEntity entity) {
        PedidoDoacao pedido = new PedidoDoacao();
        pedido.setId(entity.getId());
        pedido.setDataPedido(entity.getDataPedido());

        List<ItemPedido> itensDominio = entity.getItens().stream().map(itemEntity -> {
            ItemPedido item = new ItemPedido();
            item.setNomeProduto(itemEntity.getProduto());
            item.setQuantidade(itemEntity.getQuantidade());
            return item;
        }).collect(Collectors.toList());

        pedido.setItens(itensDominio);
        return pedido;
    }
}
