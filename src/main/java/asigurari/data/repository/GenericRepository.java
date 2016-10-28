package asigurari.data.repository;


import asigurari.controller.IController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericRepository<T> implements IController<T> {

    public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("msg_cv");
    public static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Class<T> clazz;

    public GenericRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findById(int id){

        return entityManager.find(clazz, id);
    }

    public List<T> findAll(){

        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.select(criteria.from(clazz));
        return entityManager.createQuery(criteria).getResultList();
    }


    public void save(T entity) throws Exception{
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

    }
}
