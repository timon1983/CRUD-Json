package repository;

import java.util.List;

public interface GenericReposiroty<T, ID> {

    T getByld(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteByld(ID id);
}
