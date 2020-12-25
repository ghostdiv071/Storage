package dao;

import java.util.List;

public interface DAO<T> {

    T get(int id);

    List<T> getAll();

    void create(T item);

    void update(int id, T item);

    void delete(int id);
}
