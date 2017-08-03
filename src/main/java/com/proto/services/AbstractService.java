package com.proto.services;

import java.io.Serializable;
import java.util.List;

public interface AbstractService<E> {
    /**
     *
     * @param e
     */
    void save(E e);

    /**
     *
     * @param e
     */
    void update(E e);

    /**
     *
     * @param e
     */
    void delete(E e);

    /**
     *
     * @param id
     * @return
     */
    E getById(Serializable id);

    /**
     *
     * @return
     */
    List<E> list();
}
