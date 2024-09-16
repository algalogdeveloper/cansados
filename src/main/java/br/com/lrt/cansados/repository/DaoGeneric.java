package br.com.lrt.cansados.repository;

import java.util.List;

public interface DaoGeneric<T> {

    public void jdbcConect();

    public void jdbcClose();

    public T persiste(T t);

    public List<T> all(T t);

    public T merge(T t);

    public void remove(T e);

    public T find(Long id);
    
    public Object maxId(T t);

}
