package repositories;

import entities.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LogRep {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb-persistence");

    public void addLog(Log log) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(log);
        em.getTransaction().commit();
        em.close();
    }

    public Log getLog(Long id) {
        EntityManager em = emf.createEntityManager();
        Log log = em.find(Log.class, id);
        em.close();
        return log;
    }

    public List<Log> getAllLogs() {
        EntityManager em = emf.createEntityManager();
        List<Log> logs = em.createQuery("SELECT l FROM Log l", Log.class).getResultList();
        em.close();
        return logs;
    }

    public void updateLog(Log log) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(log);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteLog(Long id) {
        EntityManager em = emf.createEntityManager();
        Log log = em.find(Log.class, id);
        if (log != null) {
            em.getTransaction().begin();
            em.remove(log);
            em.getTransaction().commit();
        }
        em.close();
    }
}
