package com.natodev.ecommerce.business.service;

import com.natodev.ecommerce.controller.dto.request.UsuarioRequestDTO;
import com.natodev.ecommerce.controller.dto.response.UsuarioResponseDTO;
import com.natodev.ecommerce.infrastructure.entity.Usuario;
import com.natodev.ecommerce.infrastructure.exception.EmailCadastradoException;
import com.natodev.ecommerce.infrastructure.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        if (usuarioRepository.existsByEmail(usuarioRequestDTO.email())){
            throw new EmailCadastradoException("E-mail " + usuarioRequestDTO.email() + " já está cadastrado!");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setSenha(usuarioRequestDTO.senha());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo.getUsuarioId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(),
                usuarioSalvo.getDataCriacao());

    }



}
