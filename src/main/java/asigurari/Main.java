package asigurari;


import asigurari.data.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Address a=new Address();
        a.setTown("Timisoara");
        a.setStreet("Bucegi");
        a.setNumber(10);
        a.setAp(4);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("insurance_project");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

    }
}
