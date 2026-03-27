package com.natodev.ecommerce.business.service;

import com.natodev.ecommerce.controller.dto.request.ProdutoRequestDTO;
import com.natodev.ecommerce.controller.dto.response.ProdutoResponseDTO;
import com.natodev.ecommerce.infrastructure.entity.Categoria;
import com.natodev.ecommerce.infrastructure.entity.Produto;
import com.natodev.ecommerce.infrastructure.exception.CategoriaNaoExisteException;
import com.natodev.ecommerce.infrastructure.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoResponseDTO salvarProduto(ProdutoRequestDTO produtoRequestDTO) {

        Produto produto = new Produto();
        produto.setNome(produtoRequestDTO.nome());
        produto.setDescricao(produtoRequestDTO.descricao());
        produto.setPreco(produtoRequestDTO.preco());
        produto.setEstoque(produtoRequestDTO.estoque());
        produto.setCategoria(produtoRequestDTO.categoriaProduto());

        if (produtoRepository.existsByCategoria(produto.getCategoria())) {
            throw new CategoriaNaoExisteException("Categoria " +  produtoRequestDTO.categoriaProduto() + " não existe!");
        }

        Produto produtoSalvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(produtoSalvo.getProdutoId(), produtoSalvo.getNome(), produtoSalvo.getDescricao(),
                produtoSalvo.getPreco(), produtoSalvo.getEstoque(), produtoSalvo.getCategoria());
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listarProdutos(String nome, Categoria categoria) {
        return produtoRepository.findAll()
                .stream()
                .map(produto -> new ProdutoResponseDTO(
                        produto.getProdutoId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getPreco(),
                        produto.getEstoque(),
                        produto.getCategoria()
                ))
                .collect(Collectors.toList());
    }
}