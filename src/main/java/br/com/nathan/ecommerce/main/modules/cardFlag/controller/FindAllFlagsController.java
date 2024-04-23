package br.com.nathan.ecommerce.main.modules.cardFlag.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import br.com.nathan.ecommerce.main.modules.cardFlag.useCases.FindAllUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.http.ResponseEntity.ok;

@AllArgsConstructor
@BaseController("cardFlags")
public class FindAllFlagsController {

    private final FindAllUseCase useCase;

    @GetMapping
    public ResponseEntity<?> handle() {
        return ok(useCase.execute());
    }
}
