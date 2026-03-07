package com.natodev.ecommerce.infrastructure.repository;

import com.natodev.ecommerce.infrastructure.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
