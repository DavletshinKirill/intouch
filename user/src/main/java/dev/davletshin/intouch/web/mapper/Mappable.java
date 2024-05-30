package dev.davletshin.intouch.web.mapper;

import java.util.Set;

public interface Mappable<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);

    Set<E> toEntity(Set<D> dtoList);

    Set<D> toDTO(Set<E> entities);
}
