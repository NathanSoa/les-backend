package br.com.nathan.ecommerce.main.modules.items.controller;

import br.com.nathan.ecommerce.main.core.annotation.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@BaseController("/items")
@RequiredArgsConstructor
public class ItemController {

    @GetMapping("/availability/{ids}")
    public ResponseEntity<?> findByIds(@PathVariable List<String> ids) {
        return ResponseEntity.ok().build();
    }
}
