package com.fiap.ong.desafioOng.infrastructure.repository;

import com.fiap.ong.desafioOng.infrastructure.repository.entity.ItemEstoqueEntity;
import com.fiap.ong.desafioOng.infrastructure.repository.jpa.EstoqueRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public class EstoqueRepositoryImpl implements EstoqueRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public BigDecimal obterQuantidadeDisponivel(String nomeProduto) {
        TypedQuery<Double> query = em.createQuery(
                "SELECT SUM(i.quantidade), 0) FROM ItemEstoqueEntity i WHERE i.nomeProduto = :nomeProduto", Double.class);
        query.setParameter("nomeProduto", nomeProduto);
        BigDecimal resultado = BigDecimal.valueOf(query.getSingleResult());
        return resultado != null ? resultado : BigDecimal.valueOf(0.0);
    }

    @Override
    @Transactional
    public void baixarEstoque(String nomeProduto, BigDecimal quantidade) {
        List<ItemEstoqueEntity> itens = em.createQuery(
                        "SELECT i FROM ItemEstoqueEntity i WHERE i.nomeProduto = :nome ORDER BY i.id", ItemEstoqueEntity.class)
                .setParameter("nome", nomeProduto)
                .getResultList();
        double restante = quantidade.doubleValue();

        for (ItemEstoqueEntity item : itens) {
            if (restante <= 0) break;

            double disponivel = item.getQuantidade();
            if (disponivel <= restante) {
                restante -= disponivel;
                em.remove(item);
            } else {
                item.setQuantidade(disponivel - restante);
                em.merge(item);
                restante = 0;
            }
        }
        if (restante > 0) {
            throw new IllegalStateException("Erro ao dar baixa: estoque inconsistente.");
        }
    }
}
