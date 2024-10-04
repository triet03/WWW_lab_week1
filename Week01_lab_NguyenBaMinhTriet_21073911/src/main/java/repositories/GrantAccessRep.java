package repositories;

import entities.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GrantAccessRep {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb-persistence");

    public void addGrantAccess(GrantAccess grantAccess) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(grantAccess);
        em.getTransaction().commit();
        em.close();
    }


    public List<GrantAccess> getAllGrantAccesses() {
        EntityManager em = emf.createEntityManager();
        List<GrantAccess> grantAccesses = em.createQuery("SELECT g FROM GrantAccess g", GrantAccess.class).getResultList();
        em.close();
        return grantAccesses;
    }

    public void updateGrantAccess(GrantAccess grantAccess) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(grantAccess);
        em.getTransaction().commit();
        em.close();
    }



}
