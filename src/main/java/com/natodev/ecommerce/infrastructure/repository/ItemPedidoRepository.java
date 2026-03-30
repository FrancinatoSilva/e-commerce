package com.natodev.ecommerce.infrastructure.repository;

import com.natodev.ecommerce.infrastructure.entity.ItemPedido;
import com.natodev.ecommerce.infrastructure.entity.Pedido;
import com.natodev.ecommerce.domain.product.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, UUID> {

    List<ItemPedido> findByPedido(Pedido pedido);
    List<ItemPedido> findByProduto(Produto produto);
}
