package repositories;

import entities.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class RoleRep {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb-persistence");

    public void addRole(Role role) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(role);
        em.getTransaction().commit();
        em.close();
    }

    public Role getRole(String roleId) {
        EntityManager em = emf.createEntityManager();
        Role role = em.find(Role.class, roleId);
        em.close();
        return role;
    }

    public List<Role> getAllRoles() {
        EntityManager em = emf.createEntityManager();
        List<Role> roles = em.createQuery("SELECT r FROM Role r", Role.class).getResultList();
        em.close();
        return roles;
    }

    public void updateRole(Role role) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(role);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteRole(String roleId) {
        EntityManager em = emf.createEntityManager();
        Role role = em.find(Role.class, roleId);
        if (role != null) {
            em.getTransaction().begin();
            em.remove(role);
            em.getTransaction().commit();
        }
        em.close();
    }
}
