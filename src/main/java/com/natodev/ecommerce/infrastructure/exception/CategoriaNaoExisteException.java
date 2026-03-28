package com.natodev.ecommerce.infrastructure.exception;

public class CategoriaNaoExisteException extends RuntimeException {
    public CategoriaNaoExisteException(String message) {
        super(message);
    }
}
