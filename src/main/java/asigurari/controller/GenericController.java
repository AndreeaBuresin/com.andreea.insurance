package asigurari.controller;

import java.util.List;

/**
 * Created by buresina on 26/10/2016.
 */
public class GenericController<T> implements IController<T>{

    private IController<T> repository;

    public GenericController(IController<T> repository) {
        this.repository = repository;
    }
    public T findById(int id) throws Exception{
        return repository.findById(id);
    }

    public List<T> findAll() throws Exception {
        return repository.findAll();
    }


    public void save(T entity) throws Exception{
        repository.save(entity);
    }
}
