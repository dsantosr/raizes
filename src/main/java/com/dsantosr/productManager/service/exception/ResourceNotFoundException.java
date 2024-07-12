package com.dsantosr.productManager.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found: " + id);
    }
}

