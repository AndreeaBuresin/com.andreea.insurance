package asigurari.controller;

import java.util.List;

/**
 * Created by buresina on 28/10/2016.
 */
public interface IController<T> {

    T findById(int id) throws Exception;

    List<T> findAll() throws Exception;


    void save(T entity) throws Exception;

}
