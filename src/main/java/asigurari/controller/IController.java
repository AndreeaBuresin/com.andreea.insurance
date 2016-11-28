package asigurari.controller;

import java.util.List;

/**
 * Created by buresina on 28/10/2016.
 */
public interface IController<T> {

    T findById(int id) throws Exception;

    T findByCnp(long cnp) throws Exception;

    List<T> findAll() throws Exception;

    List<T> findByColumn(String column, String property) throws Exception;

    void save(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(T entity) throws Exception;
}
