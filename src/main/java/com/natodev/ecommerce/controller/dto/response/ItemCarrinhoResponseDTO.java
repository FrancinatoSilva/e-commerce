package com.natodev.ecommerce.controller.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemCarrinhoResponseDTO(

        UUID itemCarrinhoId,
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario
) {}
