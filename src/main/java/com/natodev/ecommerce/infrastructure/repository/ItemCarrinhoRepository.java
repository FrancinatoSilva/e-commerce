package com.natodev.ecommerce.infrastructure.repository;

import com.natodev.ecommerce.infrastructure.entity.Carrinho;
import com.natodev.ecommerce.infrastructure.entity.ItemCarrinho;
import com.natodev.ecommerce.infrastructure.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, UUID> {

    List<ItemCarrinho> findByCarrinho(Carrinho carrinho);
    List<ItemCarrinho> findByProduto(Produto produto);
}
