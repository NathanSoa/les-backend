package br.com.nathan.ecommerce.main.core.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class ValidationException extends RuntimeException {

    private final Map<String, List<String>> errors;

    public ValidationException(Map<String, List<String>> errors) {
        super("Ocorreram erros!");
        this.errors = errors;
    }
}
