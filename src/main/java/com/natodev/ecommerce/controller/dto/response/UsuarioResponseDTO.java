package com.natodev.ecommerce.controller.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioResponseDTO(

        UUID usuarioId,
        String nome,
        String email,
        LocalDateTime dataCriacao

) {
}
