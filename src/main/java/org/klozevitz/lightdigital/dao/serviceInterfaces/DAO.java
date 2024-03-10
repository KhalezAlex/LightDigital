package org.klozevitz.lightdigital.dao.serviceInterfaces;

import java.util.List;

public interface DAO<E> {
    List<E> all();
    E findById(int id);
    E save(E e);
    boolean deleteById(int id);
}
