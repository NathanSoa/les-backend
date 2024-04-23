package br.com.nathan.ecommerce.main.core.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@AllArgsConstructor
public class MessageResolver {

    private final MessageSource messageSource;

    public String resolve(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    public String resolve(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

    public List<String> resolve(List<String> codes) {
        return codes.stream()
            .map(code -> messageSource.getMessage(code, null, Locale.getDefault()))
            .toList();
    }

    public List<String> resolve(List<String> codes, Locale locale) {
        return codes.stream()
            .map(code -> messageSource.getMessage(code, null, locale))
            .toList();
    }
}