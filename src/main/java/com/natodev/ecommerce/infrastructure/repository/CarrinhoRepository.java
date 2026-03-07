package com.natodev.ecommerce.infrastructure.repository;

import com.natodev.ecommerce.infrastructure.entity.Carrinho;
import com.natodev.ecommerce.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {

    Optional<Carrinho> findByUsuario(Usuario usuario);

}
