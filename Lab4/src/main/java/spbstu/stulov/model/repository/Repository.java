package spbstu.stulov.model.repository;

import spbstu.stulov.model.repository.specification.Specification;

import java.util.List;

public interface Repository<T> {
    void add(T obj) throws Exception;

    void delete(Specification specification) throws Exception;

    void update(Specification specification) throws Exception;

    T get(Specification specification) throws Exception;

    List<T> getList(Specification specification) throws Exception;
}
