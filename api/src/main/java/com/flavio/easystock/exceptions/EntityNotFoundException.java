package com.flavio.easystock.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("Entity %s with id %s was not found.", entityName, id));
    }
}
