package repositories;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountRep {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb-persistence");

    public void addAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }

    public Account getAccount(String accountId) {
        EntityManager em = emf.createEntityManager();
        Account account = em.find(Account.class, accountId);
        em.close();
        return account;
    }

    public List<Account> getAllAccounts() {
        EntityManager em = emf.createEntityManager();
        List<Account> accounts = em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
        em.close();
        return accounts;
    }

    public void updateAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(account);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAccount(String accountId) {
        EntityManager em = emf.createEntityManager();
        Account account = em.find(Account.class, accountId);
        if (account != null) {
            em.getTransaction().begin();
            em.remove(account);
            em.getTransaction().commit();
        }
        em.close();
    }
}
