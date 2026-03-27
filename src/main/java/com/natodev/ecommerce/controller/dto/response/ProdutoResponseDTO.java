package com.natodev.ecommerce.controller.dto.response;

import com.natodev.ecommerce.infrastructure.entity.Categoria;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDTO(

        UUID produtoId,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer estoque,
        Categoria categoriaProduto


) {}
