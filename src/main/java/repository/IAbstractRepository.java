package repository;

import java.util.List;

/**
 * Created by Anastasia on 01.12.2015.
 */
public interface IAbstractRepository<T> {

    void add(T entity);

    List<T> list();

    T find(int index);

    void update(T entity);

    void delete(int id);
}
