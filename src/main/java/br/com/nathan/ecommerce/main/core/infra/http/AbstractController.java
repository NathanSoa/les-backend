package br.com.nathan.ecommerce.main.core.infra.http;

import br.com.nathan.ecommerce.main.core.domain.AbstractService;
import br.com.nathan.ecommerce.main.core.domain.BaseEntity;
import br.com.nathan.ecommerce.main.core.interfaces.IController;
import br.com.nathan.ecommerce.main.core.interfaces.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.noContent;
import static br.com.nathan.ecommerce.main.core.infra.http.HttpHelper.ok;

public abstract class AbstractController<T, E, P> implements IController<T> {

    protected AbstractService<E, ? extends BaseEntity> service;
    protected Mapper<T, E> mapperToDomain;
    protected Mapper<E, P> mapperToPm;

    public AbstractController(
            AbstractService<E, ? extends BaseEntity> service,
            Mapper<T, E> mapperToDomain,
            Mapper<E, P> mapperToPm
    ) {
        this.service = service;
        this.mapperToDomain = mapperToDomain;
        this.mapperToPm = mapperToPm;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody T dto) {
        var data = service.create(mapperToDomain.map(dto));
        return ok(Optional.of(mapperToPm.map(data)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody T dto) {
        var data = service.update(mapperToDomain.map(dto), id);
        return ok(Optional.of(mapperToPm.map(data)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return noContent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        final var data = mapperToPm.map(service.findById(id));
        return ok(Optional.of(data));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        final var data = service.findAll()
                .stream().map(mapperToPm::map)
                .collect(Collectors.toSet());
        return ok(Optional.of(data));
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<?> updateActive(@PathVariable Long id) {
        var data = service.updateActive(id, true);
        return ok(Optional.of(mapperToPm.map(data)));
    }

    @PatchMapping("/{id}/inactive")
    public ResponseEntity<?> updateInactive(@PathVariable Long id) {
        var data = service.updateActive(id, false);
        return ok(Optional.of(mapperToPm.map(data)));
    }
}
