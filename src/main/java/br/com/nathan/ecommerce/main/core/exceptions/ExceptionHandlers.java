package br.com.nathan.ecommerce.main.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    private final MessageResolver messageResolver;

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e, WebRequest request) {
        var message = messageResolver.resolve(e.getMessage(), request.getLocale());
        log.error("ERROR: IllegalArgumentException {}", message);
        log.error(Arrays.toString(e.getStackTrace()));
        var fieldError = new FieldError(e.getMessage(), message);
        return ResponseEntity.badRequest().body(fieldError);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException e, WebRequest request) {
        var message = messageResolver.resolve(e.getMessage(), request.getLocale());
        log.error("ERROR: EntityNotFoundException {}", message);
        log.error(Arrays.toString(e.getStackTrace()));
        var fieldError = new FieldError(e.getMessage(), message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fieldError);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<?> handleBusinessException(BusinessException e, WebRequest request) {
        var message = messageResolver.resolve(e.getMessage(), request.getLocale());
        log.error("ERROR: BusinessException {}", message);
        log.error(Arrays.toString(e.getStackTrace()));
        var fieldError = new FieldError(e.getMessage(), message);
        return ResponseEntity.badRequest().body(fieldError);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<?> handleValidationException(ValidationException e, WebRequest request) {
        var map = e.getErrors();
        log.error("ERROR: ValidationException");
        map.keySet().forEach(key -> {
            log.error("Field: {}", key);
            map.get(key).forEach(message -> log.error("Message: {}", message));
        });
        log.error(Arrays.toString(e.getStackTrace()));
        return ResponseEntity.badRequest().body(e.getErrors());
    }

    private static class FieldError {
        public String field;
        public String message;

        public FieldError(String baseMessage, String message) {
            this.field = extractFieldFromBaseMessage(baseMessage);
            this.message = message;
        }

        private String extractFieldFromBaseMessage(String message) {
            return message.substring(0, message.indexOf('.'));
        }
    }
}
