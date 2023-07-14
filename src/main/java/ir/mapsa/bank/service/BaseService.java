package ir.mapsa.bank.service;

import java.util.List;

public interface BaseService<T, S, L extends Number>  {

    void save(T t);

    void update(T t);

    S getById(L id);

    S remove(L id);

    S remove(T t);

    List<S> getByExample(S example);

    List<S> getAll();


}
