package ir.mapsa.bank.repository;

import java.util.List;

public interface BaseRepository<T, S, L extends Number> extends AutoCloseable {

    T save(T t);

    T update(T t);

    T getById(L id);

    List<T> getByExample(S example);

    T remove(L id);

    T remove(T t);

    List<T> getAll();


}
