package br.com.nathan.ecommerce.main.core.domain;

import br.com.nathan.ecommerce.main.core.exceptions.ValidationException;
import br.com.nathan.ecommerce.main.core.interfaces.*;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractService<T, E extends BaseEntity> implements IService<T> {

    protected IDAO<E> dao;
    protected Mapper<T, E> mapperToEntity;
    protected Mapper<E, T> mapperToDomain;
    protected Validator<T> validator;

    public AbstractService(
        IDAO<E> dao,
        Mapper<T, E> mapperToEntity,
        Mapper<E, T> mapperToDomain,
        Validator<T> validator
    ) {
        this.dao = dao;
        this.mapperToEntity = mapperToEntity;
        this.mapperToDomain = mapperToDomain;
        this.validator = validator;
    }

    public T create(T domain) {
        throwErrorIfInvalid(domain);
        final var entity = dao.save(mapperToEntity.map(domain));
        return mapperToDomain.map(entity);
    }

    public T update(T domain, Long id) {
        throwErrorIfInvalid(domain);
        dao.findById(id);
        final var entityUpdated = dao.save(mapperToEntity.map(domain));
        return mapperToDomain.map(entityUpdated);
    }

    public T updateActive(Long id, boolean active) {
        final var entity = dao.findById(id);
        entity.setActive(active);
        final var entityUpdated = dao.save(entity);
        return mapperToDomain.map(entityUpdated);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public T findById(Long id) {
        return mapperToDomain.map(dao.findById(id));
    }

    public Set<T> findAll() {
        return dao.findAll()
                .stream()
                .map(mapperToDomain::map)
                .collect(Collectors.toSet());
    }

    private void throwErrorIfInvalid(T domain) {
        var possibleErrors = validator.validate(domain);
        if (!possibleErrors.isEmpty()) {
            throw new ValidationException(possibleErrors);
        }
    }
}
